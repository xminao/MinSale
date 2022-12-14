package pers.minho.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.minho.entity.CartItem;
import pers.minho.entity.User;
import pers.minho.service.CartService;
import pers.minho.service.UserService;
import pers.minho.util.EncryptUtil;


//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String inputEmail = request.getParameter("inputEmail");
		String inputPassword = request.getParameter("inputPassword");
		String autoLogin = request.getParameter("autoLogin");

		UserService service = new UserService();
		try {
			if (service.findByEmail(inputEmail) != null) {
				User user = service.findByEmail(inputEmail);
				String pass = EncryptUtil.MD5(EncryptUtil.MD5(inputPassword));

				//System.out.println(user.toString());

				if (user.getPwd().equals(pass)) {
					if (autoLogin != null && autoLogin.equals("on")) {
						// 目前仅用email做cookie验证
						Cookie cookie = new Cookie("LoginToken", EncryptUtil.DESencode(inputEmail));
						// 七天有效期
						cookie.setMaxAge(60 * 60 * 24 * 7);
						response.addCookie(cookie);
					}
					HttpSession session = request.getSession();
					session.setAttribute("loginUser", user);
					session.setAttribute("isLogined", true);
					
					CartService c_service = new CartService();
					session.setAttribute("cartAmount", c_service.findRowsByUserID(user.getId()));
					// 重定向到主页
					response.sendRedirect("index");
				} else {
					request.setAttribute("isLoginOk", "false");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("isLoginOk", "false");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
