package pers.minho.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.IDebugRequestor;

import pers.minho.entity.Goods;
import pers.minho.entity.User;
import pers.minho.service.CartService;
import pers.minho.service.GoodsService;
import pers.minho.util.UserUtil;

@WebServlet("/DelGoodsServlet")
public class DelGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelGoodsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String goods_id = request.getParameter("id");
		try {
			if (UserUtil.isLogined(request)) {
				GoodsService g_service = new GoodsService();
				User user = (User)session.getAttribute("loginUser");
				Goods goods = g_service.findById(Integer.parseInt(goods_id));
				if (goods != null) {
					if (user.getId() == goods.getSeller_id()) {
						g_service.delGoods(Integer.parseInt(goods_id));
					}
				}
				response.sendRedirect("index");
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
