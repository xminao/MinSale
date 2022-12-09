package pers.minho.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
