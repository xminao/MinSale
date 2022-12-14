package pers.minho.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.minho.entity.User;
import pers.minho.service.UserService;
import pers.minho.util.EncryptUtil;

//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("inputEmail");
		String pwd = request.getParameter("inputPassword");
		String pwd_confirm = request.getParameter("inputPasswordConfirm");
		String nickname = request.getParameter("nickname");
		String isEmail = "";
		String isExist = "";
		String isPwd = "";
		String isPwdSame = "";
		boolean isRegister = false;

		User user = new User();
		UserService service = new UserService();
		try {
			if (email != null && pwd != null && pwd_confirm != null && nickname != null) {
				if (email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")) {
					if ((service.findByEmail(email)) == null) {
						if (service.findByNickname(nickname) == null) {
							if (pwd.matches("[A-Za-z0-9_]{6,}")) {
								if (pwd_confirm.equals(pwd)) {
									// 两次MD5加密保存密码
									pwd = EncryptUtil.MD5(EncryptUtil.MD5(pwd));
									user.setEmail(email);
									user.setPwd(pwd);
									user.setNickname(nickname);

									if (service.addUser(user)) {
										isRegister = true;
									}

									request.setAttribute("isRegister", isRegister);
								} else {
									isPwdSame = "两次密码不一致";
								}
							} else {
								isPwd = "密码格式错误";
							}
						} else {
							isExist = "该昵称用户已经存在";
						}
					} else {
						isExist = "该邮箱用户已经存在";
					}
				} else {
					isEmail = "邮箱格式错误或已经存在";
				}

				if(isRegister) {
					request.setAttribute("isRegister", isRegister);
					// 转发到登录界面
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				} else {
					request.setAttribute("isRegister", false);
					request.setAttribute("isPwdSame", isPwdSame);
					request.setAttribute("isPwd", isPwd);
					request.setAttribute("isEmail", isEmail);
					request.setAttribute("isExist", isExist);
					// 转发到注册界面
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("isRegister", false);
				request.getRequestDispatcher("register.jsp").forward(request, response);
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
