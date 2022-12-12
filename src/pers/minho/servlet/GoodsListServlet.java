package pers.minho.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.minho.entity.Goods;
import pers.minho.entity.User;
import pers.minho.service.GoodsService;
import pers.minho.service.UserService;

@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GoodsListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			GoodsService g_service = new GoodsService();
			UserService u_service = new UserService();
			List<Goods> goods = g_service.findAll();
			Map<Integer, User> map = new HashMap<Integer, User>();
			for (Goods good : goods) {
				map.put(good.getSeller_id(), u_service.findById(good.getSeller_id()));
			}
			request.setAttribute("goodsList", goods);
			request.setAttribute("userMap", map);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
