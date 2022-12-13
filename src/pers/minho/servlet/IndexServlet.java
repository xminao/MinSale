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
import pers.minho.entity.GoodsPage;
import pers.minho.entity.User;
import pers.minho.service.GoodsService;
import pers.minho.service.UserService;

//@WebServlet("/UtilServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			GoodsService g_service = new GoodsService();
			UserService u_service = new UserService();
			GoodsPage page = new GoodsPage();
			// 如果不足十个就只要五个甚至五个以内，保证界面美观
			if (g_service.findRows() < 10) {
				page.setPageSize(5);
			} else {
				page.setPageSize(10);
			}
			
			page.setRows(g_service.findRows());
			page.setTotalPage(page.getTotalPage());
			List<Goods> goods = g_service.findByPage(page);
			
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
