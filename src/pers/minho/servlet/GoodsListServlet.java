package pers.minho.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.google.gson.Gson;

@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GoodsListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("刀哥");
			String currentPage = request.getParameter("currentPage");
			
			GoodsService g_service = new GoodsService();
			UserService u_service = new UserService();
			List<Goods> goods = g_service.findAll();
			
			GoodsPage page = new GoodsPage();
			page.setPageSize(3);
			page.setRows(g_service.findRows());
			page.setTotalPage(page.getTotalPage());
			if (currentPage != null) {
				page.setCurrentPage(Integer.parseInt(currentPage));
			}
			//page.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
			List<Goods> goods_page = g_service.findByPage(page);
			
			Map<Integer, User> map = new HashMap<Integer, User>();
			for (Goods good : goods) {
				map.put(good.getSeller_id(), u_service.findById(good.getSeller_id()));
			}
			
			request.setAttribute("goodsPage", page);
			request.setAttribute("goodsPageList", goods_page);
			request.setAttribute("goodsList", goods);
			request.setAttribute("userMap", map);
			request.getRequestDispatcher("/lastest_goods.jsp").forward(request, response);
			//request.getRequestDispatcher("/lastest_goods.jsp").forward(request, response);
			//response.setIntHeader("Refresh", 0);
//			Gson gson = new Gson();
//			
//			HashMap<String, String> m = new HashMap<String, String>();
//			
//			String pageJsonStr = gson.toJson(page);
//			String goodsJsonStr = gson.toJson(goods_page);
//			m.put("pageJsonStr", pageJsonStr);
//			m.put("goodsJsonStr", goodsJsonStr);
//			String mapJsonStr = gson.toJson(m);
//			PrintWriter out = response.getWriter();
//			out.write(mapJsonStr);
//			out.flush();
//			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
