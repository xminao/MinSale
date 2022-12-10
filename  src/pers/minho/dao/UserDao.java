package pers.minho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.minho.entity.User;
import pers.minho.util.DBUtil;

public class UserDao {
	// 数据库连接
	private Connection conn = null;
	// 执行语句
	private PreparedStatement prep = null;
	
	public UserDao() {
		try {
			this.conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 添加用户
	public boolean addUser(User user) {
		boolean flag = false;
		String sql = "INSERT INTO `user`(email, pwd, nickname, phone, img) VALUES(?, ?, ?, ?, ?)";	
		
		try {
			this.prep = this.conn.prepareStatement(sql);
			prep.setString(1, user.getEmail());
			prep.setString(2, user.getPwd());
			prep.setString(3, user.getNickname());
			prep.setString(4, user.getPhone());
			// prep.setString(5, user.getImg());
			prep.setString(5, "/views/static/user_img/default.png");
			if (prep.executeUpdate() > 0) {
				flag = true;
			}
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	// 更新用户
	public boolean updateUser(User user) {
		boolean flag = false;
		String sql = "UPDATE user SET email=?, pwd=?, nickname=?, phone=?, img=? WHERE id=?";	
		
		try {
			this.prep = this.conn.prepareStatement(sql);
			prep.setString(1, user.getEmail());
			prep.setString(2, user.getPwd());
			prep.setString(3, user.getNickname());
			prep.setString(4, user.getPhone());
			prep.setString(5, user.getImg());
			prep.setInt(6, user.getId());
			if (prep.executeUpdate() > 0) {
				flag = true;
			}
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	// 根据ID查找用户
	public User findById(int id) {
		User user = null;
		String sql = "SELECT id, email, pwd, nickname, phone, img FROM user WHERE id=?";
		
		try {
			this.prep = this.conn.prepareStatement(sql);
			this.prep.setInt(1, id);
			ResultSet rSet = this.prep.executeQuery();
			if (rSet.next()) {
				user = new User();
				user.setId(rSet.getInt(1));
				user.setEmail(rSet.getString(2));
				user.setPwd(rSet.getString(3));
				user.setNickname(rSet.getString(4));
				user.setPhone(rSet.getString(5));
				user.setImg(rSet.getString(6));
			}
			rSet.close();
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	// 根据邮箱查找用户
	public User findByEmail(String email) {
		User user = null;
		String sql = "SELECT id, email, pwd, nickname, phone, img FROM user WHERE email=?";
		
		try {
			this.prep = this.conn.prepareStatement(sql);
			this.prep.setString(1, email);
			ResultSet rSet = this.prep.executeQuery();
			if (rSet.next()) {
				user = new User();
				user.setId(rSet.getInt(1));
				user.setEmail(rSet.getString(2));
				user.setPwd(rSet.getString(3));
				user.setNickname(rSet.getString(4));
				user.setPhone(rSet.getString(5));
				user.setImg(rSet.getString(6));
			}
			rSet.close();
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	// 根据昵称查找用户
	public User findByNickname(String nickname) {
		User user = null;
		String sql = "SELECT id, email, pwd, nickname, phone, img FROM user WHERE nickname=?";
		
		try {
			this.prep = this.conn.prepareStatement(sql);
			this.prep.setString(1, nickname);
			ResultSet rSet = this.prep.executeQuery();
			if (rSet.next()) {
				user = new User();
				user.setId(rSet.getInt(1));
				user.setEmail(rSet.getString(2));
				user.setPwd(rSet.getString(3));
				user.setNickname(rSet.getString(4));
				user.setPhone(rSet.getString(5));
				user.setImg(rSet.getString(6));
			}
			rSet.close();
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	// 查找所有用户
	public List<User> findAll() {
		List<User> all = new ArrayList<User>();
		String sql = "SELECT * FROM user";
		
		try {
			this.prep = this.conn.prepareStatement(sql);
			ResultSet rSet = this.prep.executeQuery();
			User user = null;
			while (rSet.next()) {
				user = new User();
				user.setEmail(rSet.getString(1));
				user.setPwd(rSet.getString(2));
				user.setNickname(rSet.getString(3));
				user.setPhone(rSet.getString(4));
				user.setImg(rSet.getString(5));
				all.add(user);
			}
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}
	
	// 通过邮件或名字关键字查找
	public List<User> findAllbyKeyword(String keyword) {
		List<User> all = new ArrayList<User>();
		String sql = "SELECT * FROM user WHERE nickname LIKE ? OR email LIKE ?";
		
		try {
			this.prep = this.conn.prepareStatement(sql);
			this.prep.setString(1,  "%" + keyword + "%");
			this.prep.setString(2,  "%" + keyword + "%");
			ResultSet rSet = this.prep.executeQuery();
			User user = null;
			while (rSet.next()) {
				user = new User();
				user.setEmail(rSet.getString(1));
				user.setPwd(rSet.getString(2));
				user.setNickname(rSet.getString(3));
				user.setPhone(rSet.getString(4));
				user.setImg(rSet.getString(5));
				all.add(user);
			}
			this.prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}
}
