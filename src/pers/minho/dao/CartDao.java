package pers.minho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.minho.entity.CartItem;
import pers.minho.util.DBUtil;

public class CartDao {
	// 数据库连接
	private Connection conn = null;
	// 执行语句
	private PreparedStatement prep = null;

	public CartDao() {
		try {
			this.conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 增加购物车物品
	public boolean addCartItem(CartItem item) {
		boolean flag = false;
		String sql = "INSERT INTO `cart`(`goods_id`, `user_id`, `seller_id`) VALUES(?, ?, ?)";
		
		try {
			this.prep = this.conn.prepareStatement(sql);
			prep.setInt(1, item.getGoods_id());
			prep.setInt(2, item.getUser_id());
			prep.setInt(3, item.getSeller_id());

			if (prep.executeUpdate() > 0) {
				flag = true;
			}
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	// 删除购物车物品
	public boolean delCartItem(int ItemId) {
		boolean flag = false;
		String sql = "UPDATE `cart` SET `is_del`=1 WHERE `id`=?";
		
		try {
			this.prep =  this.conn.prepareStatement(sql);
			prep.setInt(1, ItemId);
			
			if (prep.executeUpdate() > 0) {
				flag = true;
			}
			this.prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// 根据用户名查找所有购物车
	public List<CartItem> findByUserID(int id) {
		List<CartItem> all = new ArrayList<CartItem>();
		String sql = "SELECT `id`, `goods_id`, `user_id`, `seller_id` FROM `cart` WHERE `user_id`=? AND `is_del`=0";

		try {
			this.prep = this.conn.prepareStatement(sql);
			this.prep.setInt(1, id);
			ResultSet rSet = this.prep.executeQuery();
			CartItem cart = null;
			while (rSet.next()) {
				cart = new CartItem();
				cart.setId(rSet.getInt("id"));
				cart.setGoods_id(rSet.getInt("goods_id"));
				cart.setUser_id(rSet.getInt("user_id"));
				cart.setSeller_id(rSet.getInt("seller_id"));
				all.add(cart);
			}
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}
	
	// 根据用户ID获取购物车数量
	public int findRowsByUserID(int id) {
		int rows = 0;
		String sql = "SELECT COUNT(*) rows FROM `cart` WHERE `user_id`=? AND `is_del`=0";
		try {
			this.prep = this.conn.prepareStatement(sql);
			this.prep.setInt(1, id);
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
