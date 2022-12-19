package pers.minho.service;

import java.util.List;

import pers.minho.dao.CategorizeDao;
import pers.minho.entity.Categorize;

public class CategorizeService {
	private CategorizeDao dao = new CategorizeDao();
	
	public List<Categorize> findAll() {
		return dao.findAll();
	}
	
	public Categorize findById(int id) {
		return dao.findById(id);
	}
}
