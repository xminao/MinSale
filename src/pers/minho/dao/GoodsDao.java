package pers.minho.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import pers.minho.entity.Goods;
import pers.minho.entity.GoodsPage;
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
		String sql = "INSERT INTO `goods`(img, type_id, `name`, `amount`, price, `is_del`, `desc`, seller_id, create_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			this.prep = this.conn.prepareStatement(sql);
			prep.setString(1, goods.getImg());
			prep.setInt(2, goods.getType_id());
			prep.setString(3, goods.getName());
			prep.setInt(4, goods.getAmount());
			prep.setDouble(5, goods.getPrice());
			prep.setInt(6, goods.getIs_del());
			prep.setString(7, goods.getDesc());
			prep.setInt(8, goods.getSeller_id());
			java.util.Date date = new java.util.Date();
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			prep.setTimestamp(9, Timestamp.valueOf(simpleDate.format(date)));
			//prep.setDate(9, (Date)goods.getCreate_date());

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
		String sql = "UPDATE goods SET img=?, type_id=?, `name`=?, `amount`=?, price=?, `is_del`=?, `desc`=?, seller_id=?, create_date=? WHERE id=?";

		try {
			this.prep = this.conn.prepareStatement(sql);
			prep.setString(1, goods.getImg());
			prep.setInt(2, goods.getType_id());
			prep.setString(3, goods.getName());
			prep.setInt(4, goods.getAmount());
			prep.setDouble(5, goods.getPrice());
			prep.setInt(6, goods.getIs_del());
			prep.setString(7, goods.getDesc());
			prep.setInt(8, goods.getSeller_id());
			prep.setDate(9, (Date)goods.getCreate_date()); //改
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

	// 下架商品
	public boolean delGoods(int id) {
		boolean flag = false;
		String sql = "UPDATE `goods` SET `is_del`=1 WHERE `id`=?";
		
		try {
			this.prep =  this.conn.prepareStatement(sql);
			prep.setInt(1, id);
			
			if (prep.executeUpdate() > 0) {
				flag = true;
			}
			this.prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	// 根据ID查找商品
	public Goods findById(int id) {
		Goods goods = null;
		String sql = "SELECT id, img, type_id, `name`, `amount`, price, `is_del`, `desc`, seller_id, create_date FROM goods WHERE id=? AND `is_del`=0";

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
				goods.setIs_del(rSet.getInt(7));
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
	
	public List<Goods> findByPage(GoodsPage page){
		List<Goods> page_all = new ArrayList<Goods>();
		String sql = "SELECT * FROM goods WHERE `is_del`=0 ORDER BY `create_date` DESC LIMIT ?,?";
		String sql_search = "SELECT * FROM goods WHERE `name` LIKE ? AND `is_del`=0 ORDER BY `create_date` LIMIT ?,?";
		try {
			ResultSet rSet = null;
			// 有搜索条件
			if (page.getSearchName() != null) {
				this.prep = this.conn.prepareStatement(sql_search);
				this.prep.setString(1, "%" + page.getSearchName() + "%");
				this.prep.setInt(2, page.getBegin());
				this.prep.setInt(3, page.getPageSize());
				rSet = this.prep.executeQuery();
				
			} else {
				this.prep = this.conn.prepareStatement(sql);
				this.prep.setInt(1, page.getBegin());
				this.prep.setInt(2, page.getPageSize());
				rSet = this.prep.executeQuery();
			}
			Goods goods = null;
			while (rSet.next()) {
				goods = new Goods();
				goods.setId(rSet.getInt("id"));
				goods.setImg(rSet.getString("img"));
				goods.setType_id(rSet.getInt("type_id"));
				goods.setName(rSet.getString("name"));
				goods.setAmount(rSet.getInt("amount"));
				goods.setPrice(rSet.getDouble("price"));
				goods.setIs_del(rSet.getInt("is_del"));
				goods.setDesc(rSet.getString("desc"));
				goods.setSeller_id(rSet.getInt("seller_id"));
				goods.setCreate_date(rSet.getDate("create_date"));
				page_all.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page_all;
	}
	
	// 根据商品名查找
	public List<Goods> findByName(String name) {
		List<Goods> all = new ArrayList<Goods>();
		String sql = "SELECT * FROM goods WHERE `name` LIKE ? AND `is_del`=0";
		
		try {
			this.prep = this.conn.prepareStatement(sql);
			this.prep.setString(1, "%" + name + "%");
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
				goods.setIs_del(rSet.getInt(7));
				goods.setDesc(rSet.getString(8));
				goods.setSeller_id(rSet.getInt(9));
				goods.setCreate_date(rSet.getDate(10));
				all.add(goods);
			}
			this.prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	// 查找所有商品
	public List<Goods> findAll() {
		List<Goods> all = new ArrayList<>();
		String sql = "SELECT id, img, type_id, `name`, `amount`, price, `is_del`, `desc`, seller_id, create_date FROM goods WHERE `is_del`=0";
		//String sql = "SELECT g.id, g.img, g.type_id, g.`name`, g.price, g.`status`, g.`desc`, g.seller_id, g.create_date, u.nickname FROM `goods` g, `user` u WHERE g.seller_id=u.id";

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
				goods.setIs_del(rSet.getInt(7));
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
	
	// 获取商品数量
	public int findRows() {
		int rows = 0;
		String sql = "SELECT COUNT(*) rows FROM goods WHERE `is_del`=0";
		try {
			this.prep = this.conn.prepareStatement(sql);
			ResultSet rSet = this.prep.executeQuery();
			if (rSet.next()) {
				rows = rSet.getInt("rows");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}
