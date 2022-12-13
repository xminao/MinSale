package pers.minho.test;

import java.util.List;

import org.apache.naming.java.javaURLContextFactory;

import pers.minho.dao.GoodsDao;
import pers.minho.dao.UserDao;
import pers.minho.entity.Goods;
import pers.minho.entity.GoodsPage;

public class DaoTest {

	// 商品操作测试
	public static void GoodsDaoTest() {
		GoodsDao dao = new GoodsDao();
// 增加商品测试
//		Goods goods = new Goods();
//		goods.setType_id(1);
//		goods.setName("机油桶");
//		goods.setAmount(1);
//		goods.setPrice(99.8);
//		goods.setStatus(1);
//		goods.setDesc("刀哥用过的机油桶");
//		goods.setSeller_id(5);
//		Date date = new Date();
//		goods.setCreate_date(new java.sql.Date(date.getTime()));
//		boolean flag = dao.addGoods(goods);
//		System.out.println(flag);

// 更新商品测试
//		Goods goods = new Goods();
//		goods.setId(1);
//		goods.setImg("/static/good_img/jyt.png");
//		goods.setType_id(1);
//		goods.setName("机油桶");
//		goods.setAmount(1);
//		goods.setPrice(99.9);
//		goods.setStatus(1);
//		goods.setDesc("刀哥用过的机油桶");
//		goods.setSeller_id(5);
//		Date date = new Date();
//		goods.setCreate_date(new java.sql.Date(date.getTime()));
//		boolean flag = dao.updateGoods(goods);
//		System.out.println(flag);

// 根据ID查找商品测试
//		Goods goods = dao.findById(1);
//		System.out.println(goods.toString());

// 查找所有商品测试
//		List<Goods> goods = dao.findAll();
//		for (Goods good : goods) {
//			System.out.println(good.toString());
//		}
		
//		java.util.Date date = new java.util.Date();
//		java.sql.Timestamp dateTime = new java.sql.Timestamp(date.getTime());
//		System.out.println(dateTime);
		
// 分页查询测试
//		GoodsPage page = new GoodsPage();
//		page.setCurrentPage(3);
//		page.setRows(dao.findRows());
//		page.setPageSize(2);
//		List<Goods> goods = dao.findByPage(page);
//		for (Goods good : goods) {
//			System.out.println(good.toString());
//		}
		
		
	}

	// 用户操作测试
	public static void UserDaoTest() {
		UserDao dao = new UserDao();

// 添加用户
//		User user = new User();
//		user.setEmail("xminao@yeah.net");
//		user.setPwd("password");
//		user.setNickname("沪宁");
//		user.setPhone("12233334444");
//		user.setImg("static/img.png");
//		boolean flag = dao.addUser(user);
//		System.out.println(flag);

// 更新用户
//		User user = new User();
//		user.setId(1);
//		user.setEmail("xminao@yeah.net");
//		user.setPwd("changepwd");
//		user.setNickname("沪宁");
//		user.setPhone("12233335555");
//		user.setImg("static/img.png");
//		boolean flag = dao.updateUser(user);
//		System.out.println(flag);

// 查找所有用户
//		List<User> alList = dao.findAll();
//		for (User user : alList) {
//			System.out.println(user.toString());
//		}

// 查找所有匹配关键字的用户
//		List<User> alList = dao.findAllbyKeyword("沪宁");
//		for (User user : alList) {
//			System.out.println(user.toString());
//		}

// 根据ID查找用户
//		User user = dao.findById(1);
//		System.out.println(user.toString());

// 根据邮箱查找用户
//		User user = dao.findByEmail("xminao@yeah.net");
//		System.out.println(user.toString());
	}

	public static void main(String[] args) {
		GoodsDaoTest();
		//UserDaoTest();
	}
}
