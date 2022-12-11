package pers.minho.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.minho.entity.Goods;
import pers.minho.entity.User;
import pers.minho.service.GoodsService;
import pers.minho.service.UserService;
import pers.minho.util.UserUtil;

//@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		GoodsService g_service = new GoodsService();
		UserService u_service = new UserService();
		
		if (UserUtil.isLogined(request)) {
			String inputTitle = request.getParameter("inputTitle");
			int selectType = Integer.parseInt(request.getParameter("selectType"));
			String inputDesc = request.getParameter("inputDesc");
			double inputPrice = Double.parseDouble(request.getParameter("inputPrice"));
			
			String emailCookie = null;
			User user = null;
			Goods goods = null;
			
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("LOGIN_EMAIL_COOKIE".equals(cookie.getName())) {
						emailCookie = cookie.getValue();
						try {
							if (u_service.findByEmail(emailCookie) != null) {
								user = u_service.findByEmail(emailCookie);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			if (user != null) {
				goods = new Goods();
				goods.setType_id(selectType);
				goods.setName(inputTitle);
				goods.setAmount(1);
				goods.setPrice(inputPrice);
				goods.setStatus(1);
				goods.setDesc(inputDesc);
				goods.setSeller_id(user.getId());
				
				if (g_service.addGoods(goods)) {
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
