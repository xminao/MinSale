package pers.minho.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.minho.entity.Goods;
import pers.minho.util.DBUtil;

public class GoodsDao {
	// 数据库连接
	private Connection conn = null;
	// 执行语句
	private PreparedStatement prep = null;

	public GoodsDao() {
		try {
			this.conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 添加用户
	public boolean addGoods(Goods goods) {
		boolean flag = false;
		String sql = "INSERT INTO `goods`(img, type_id, `name`, `amount`, price, `status`, `desc`, seller_id, create_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			this.prep = this.conn.prepareStatement(sql);
			prep.setString(1, "/views/static/goods_img/default.png");
			prep.setInt(2, goods.getType_id());
			prep.setString(3, goods.getName());
			prep.setInt(4, goods.getAmount());
			prep.setDouble(5, goods.getPrice());
			prep.setInt(6, goods.getStatus());
			prep.setString(7, goods.getDesc());
			prep.setInt(8, goods.getSeller_id());
			prep.setDate(9, (Date)goods.getCreate_date());

			if (prep.executeUpdate() > 0) {
				flag = true;
			}
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	// 更新商品
	public boolean updateGoods(Goods goods) {
		boolean flag = false;
		String sql = "UPDATE goods SET img=?, type_id=?, `name`=?, `amount`=?, price=?, `status`=?, `desc`=?, seller_id=?, create_date=? WHERE id=?";

		try {
			this.prep = this.conn.prepareStatement(sql);
			prep.setString(1, goods.getImg());
			prep.setInt(2, goods.getType_id());
			prep.setString(3, goods.getName());
			prep.setInt(4, goods.getAmount());
			prep.setDouble(5, goods.getPrice());
			prep.setInt(6, goods.getStatus());
			prep.setString(7, goods.getDesc());
			prep.setInt(8, goods.getSeller_id());
			prep.setDate(9, (Date)goods.getCreate_date());
			prep.setInt(10, goods.getId());

			if (prep.executeUpdate() > 0) {
				flag = true;
			}
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	// 根据ID查找商品
	public Goods findById(int id) {
		Goods goods = null;
		String sql = "SELECT id, img, type_id, `name`, `amount`, price, `status`, `desc`, seller_id, create_date FROM goods WHERE id=?";

		try {
			this.prep = this.conn.prepareStatement(sql);
			this.prep.setInt(1, id);
			ResultSet rSet = this.prep.executeQuery();
			if (rSet.next()) {
				goods = new Goods();
				goods.setId(id);
				goods.setImg(rSet.getString(2));
				goods.setType_id(rSet.getInt(3));
				goods.setName(rSet.getString(4));
				goods.setAmount(rSet.getInt(5));
				goods.setPrice(rSet.getDouble(6));
				goods.setStatus(rSet.getInt(7));
				goods.setDesc(rSet.getString(8));
				goods.setSeller_id(rSet.getInt(9));
				goods.setCreate_date(rSet.getDate(10));
			}
			rSet.close();
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}

	// 查找所有商品
	public List<Goods> findAll() {
		List<Goods> all = new ArrayList<>();
		String sql = "SELECT id, img, type_id, `name`, `amount`, price, `status`, `desc`, seller_id, create_date FROM goods";

		try {
			this.prep = this.conn.prepareStatement(sql);
			ResultSet rSet = this.prep.executeQuery();
			Goods goods = null;
			while (rSet.next()) {
				goods = new Goods();
				goods.setId(rSet.getInt(1));
				goods.setImg(rSet.getString(2));
				goods.setType_id(rSet.getInt(3));
				goods.setName(rSet.getString(4));
				goods.setAmount(rSet.getInt(5));
				goods.setPrice(rSet.getDouble(6));
				goods.setStatus(rSet.getInt(7));
				goods.setDesc(rSet.getString(8));
				goods.setSeller_id(rSet.getInt(9));
				goods.setCreate_date(rSet.getDate(10));
				all.add(goods);
			}
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}
}
