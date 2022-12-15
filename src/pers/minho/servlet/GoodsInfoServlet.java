package pers.minho.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.minho.entity.CartItem;
import pers.minho.entity.Goods;
import pers.minho.entity.User;
import pers.minho.service.CartService;
import pers.minho.service.GoodsService;
import pers.minho.service.UserService;
import pers.minho.util.UserUtil;


//@WebServlet("/GoodsInfoServlet")
public class GoodsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		try {
			GoodsService g_service = new GoodsService();
			UserService u_service = new UserService();
			CartService c_service = new CartService();
			
			if (id != null) {
				Goods good = g_service.findById(Integer.parseInt(id));
				if (good != null) {
					request.setAttribute("goods", good);
					request.setAttribute("seller", u_service.findById(good.getSeller_id()));
					// 如果登录，判断商品是否在该用户购物车
					if (UserUtil.isLogined(request)) {
						boolean inCart = false;
						User user = (User)session.getAttribute("loginUser");
						List<CartItem> cart = c_service.findByUserID(user.getId());
						for (CartItem item : cart) {
							if (item.getUser_id() == user.getId() && item.getGoods_id() == good.getId()) {
								inCart = true;
							}
						}
						request.setAttribute("inCart", inCart);
					}
					request.getRequestDispatcher("/goods_info.jsp").forward(request, response);
				} else {
					// 重定向到主页
					response.sendRedirect("index");
				}
			} else {
				// 重定向到主页
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
