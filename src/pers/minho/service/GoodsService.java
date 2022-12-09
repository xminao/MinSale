package pers.minho.service;

import pers.minho.dao.GoodsDao;
import pers.minho.entity.Goods;

public class GoodsService {
	private GoodsDao dao = new GoodsDao();
	
	public boolean addGoods(Goods goods) {
		return dao.addGoods(goods);
	}
}
