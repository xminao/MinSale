package pers.minho.servlet;

import java.io.IOException;
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
import pers.minho.util.UserUtil;


@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCartServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = (HttpSession)request.getSession();
		String goodsId = request.getParameter("goodsId");
		try {
			if (UserUtil.isLogined(request)) {
				CartService c_service = new CartService();
				GoodsService g_service = new GoodsService();
				User user = (User)ses.getAttribute("loginUser");
				Goods good = g_service.findById(Integer.parseInt(goodsId));
				CartItem item = null;
				if (good != null) {
					item = new CartItem();
					item.setUser_id(user.getId());
					item.setGoods_id(good.getId());
					item.setSeller_id(good.getSeller_id());
					
					if (c_service.addCartItem(item)) {
						response.sendRedirect("cart");
					} else {
						request.getRequestDispatcher("/goods_info?goodsid=" + goodsId).forward(request, response);
					}
				}
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
