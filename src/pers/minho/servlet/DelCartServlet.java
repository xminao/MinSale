package pers.minho.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pers.minho.service.CartService;
import pers.minho.util.UserUtil;

@WebServlet("/DelCartServlet")
public class DelCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DelCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemId = request.getParameter("delId");
		try {
			if (UserUtil.isLogined(request)) {
				CartService c_service = new CartService();
				
				c_service.delCartItem(Integer.parseInt(itemId));
				response.sendRedirect("cart");
			} else {
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
