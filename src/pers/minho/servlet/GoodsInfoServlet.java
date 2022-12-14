package pers.minho.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.minho.entity.Goods;
import pers.minho.service.GoodsService;
import pers.minho.service.UserService;


//@WebServlet("/GoodsInfoServlet")
public class GoodsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("goodsid");
		try {
			GoodsService g_service = new GoodsService();
			UserService u_service = new UserService();
			
			if (id != null) {
				Goods good = g_service.findById(Integer.parseInt(id));
				if (good != null) {
					request.setAttribute("goods", good);
					request.setAttribute("seller", u_service.findById(good.getSeller_id()));
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
