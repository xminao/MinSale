package pers.minho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pers.minho.entity.Categorize;
import pers.minho.util.DBUtil;

public class CategorizeDao {
	// 数据库连接
	private Connection conn = null;
	// 执行语句
	private PreparedStatement prep = null;

	public CategorizeDao() {
		try {
			this.conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Categorize> findAll() {
		List<Categorize> all = new ArrayList<Categorize>();
		String sql = "SELECT `id`, `name`, `img` FROM `categorize`";
		try {
			this.prep = this.conn.prepareStatement(sql);
			ResultSet rSet = this.prep.executeQuery();
			Categorize categorize  = null;
			while (rSet.next()) {
				categorize = new Categorize();
				categorize.setId(rSet.getInt("id"));
				categorize.setName(rSet.getString("name"));
				categorize.setImg(rSet.getString("img"));
				all.add(categorize);
			}
			rSet.close();
			this.prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}
	
	public Categorize findById(int id) {
		Categorize categorize = null;
		String sql = "SELECT * FROM `categorize` WHERE `id`=?";
		try {
			this.prep = this.conn.prepareStatement(sql);
			this.prep.setInt(1, id);
			ResultSet rSet = this.prep.executeQuery();
			if (rSet.next()) {
				categorize = new Categorize();
				categorize.setId(rSet.getInt("id"));
				categorize.setName(rSet.getString("name"));
				categorize.setImg(rSet.getString("img"));
			}
			rSet.close();
			this.prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categorize;
	}
	
	
}
