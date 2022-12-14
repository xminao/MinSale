package pers.minho.service;

import java.util.List;

import pers.minho.dao.CartDao;
import pers.minho.entity.CartItem;
import pers.minho.entity.Goods;

public class CartService {
	private CartDao dao = new CartDao();
	
	public boolean addCartItem(CartItem item) {
		return dao.addCartItem(item);
	}
	
	public boolean delCartItem(int ItemId) {
		return dao.delCartItem(ItemId);
	}
	
	public List<CartItem> findByUserID(int id) {
		return dao.findByUserID(id);
	}
	
	public int findRowsByUserID(int id) {
		return dao.findRowsByUserID(id);
	}
	
	public Goods getCartGoods(CartItem item) {
		GoodsService g_service = new GoodsService();
		Goods goods = g_service.findById(item.getGoods_id());
		return goods;
	}
	
}
