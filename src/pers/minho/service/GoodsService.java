package pers.minho.service;

import java.util.List;

import pers.minho.dao.GoodsDao;
import pers.minho.entity.Goods;

public class GoodsService {
	private GoodsDao dao = new GoodsDao();

	public boolean addGoods(Goods goods) {
		return dao.addGoods(goods);
	}

	public boolean updateGoods(Goods goods) {
		return dao.updateGoods(goods);
	}

	public Goods findById(int id) {
		return dao.findById(id);
	}

	public List<Goods> findAll() {
		return dao.findAll();
	}
}
