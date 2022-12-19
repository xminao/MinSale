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

import pers.minho.entity.Categorize;
import pers.minho.entity.Goods;
import pers.minho.entity.GoodsPage;
import pers.minho.entity.User;
import pers.minho.service.CategorizeService;
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
		String currentPage = request.getParameter("currentPage");
		String searchName = request.getParameter("searchName");
		String categorizeType = request.getParameter("type");
		System.out.println(categorizeType);
		try {
			GoodsService g_service = new GoodsService();
			UserService u_service = new UserService();
			CategorizeService cg_service = new CategorizeService();
			
			GoodsPage page = new GoodsPage();
			if (currentPage != null) {
				page.setCurrentPage(Integer.parseInt(currentPage));
			}
			if (searchName != null) {
				page.setSearchName(searchName);
			}
			if (categorizeType != null) {
				page.setCategorize(Integer.parseInt(categorizeType));
			}
			page.setPageSize(10);
			page.setRows(g_service.findRows(page));
			page.setTotalPage(page.getTotalPage());

			List<Goods> goods = g_service.findByPage(page);
			
			Map<Integer, User> map = new HashMap<Integer, User>();
			for (Goods good : goods) {
				map.put(good.getSeller_id(), u_service.findById(good.getSeller_id()));
			}
			
			if (categorizeType != null) {
				Categorize categorize = cg_service.findById(Integer.parseInt(categorizeType));
				request.setAttribute("categorize", categorize);
			}
			
			request.setAttribute("goodsPage", page);
			request.setAttribute("goodsPageList", goods);
			request.setAttribute("userMap", map);
			request.getRequestDispatcher("/goods_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
