package pers.minho.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.minho.entity.CartItem;
import pers.minho.entity.Goods;
import pers.minho.entity.User;
import pers.minho.service.CartService;
import pers.minho.service.UserService;
import pers.minho.util.UserUtil;


//@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		try {
			if (UserUtil.isLogined(request)) {
				User user = (User)ses.getAttribute("loginUser");
				UserService u_service = new UserService();
				CartService c_service = new CartService();
				
				List<CartItem> cart = c_service.findByUserID(user.getId());
				Map<Integer, Goods> goods_map = new HashMap<Integer, Goods>();
				for (CartItem item : cart) {
					goods_map.put(item.getId(), c_service.getCartGoods(item));
				}
				
				request.setAttribute("cartMap", goods_map);
				//request.setAttribute("sellerMap", seller_map);
				
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
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
