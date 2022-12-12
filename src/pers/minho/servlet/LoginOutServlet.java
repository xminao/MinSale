package pers.minho.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.minho.util.UserUtil;

@WebServlet("/LoginOutServlet")
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginOutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();

		try {
			if (UserUtil.isLogined(request)) {
				ses.removeAttribute("isLogined");
				ses.removeAttribute("loginUser");
				
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("LoginToken")) {
							Cookie delCookie = new Cookie(cookie.getName(), "");
							delCookie.setMaxAge(0);
							response.addCookie(delCookie);
						}
					}
				}
				
				//response.sendRedirect("index.jsp");
				response.sendRedirect("index");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
