package pers.minho.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.minho.entity.User;
import pers.minho.service.UserService;

//@WebServlet("/PersonalServlet")
public class PersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PersonalServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String new_nickname = request.getParameter("new_nickname");
		try {
			User user = (User)session.getAttribute("loginUser");
			if (user == null) {
				response.sendRedirect("index");
				return;
			}
			
			request.setAttribute("user", user);
			
			UserService u_service = new UserService();
			if (new_nickname != null) {
				if (u_service.findByNickname(new_nickname) == null) {
					user.setNickname(new_nickname);
					u_service.updateUser(user);
				}
				response.sendRedirect("personal");
				return;
			}
			request.getRequestDispatcher("personal.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
