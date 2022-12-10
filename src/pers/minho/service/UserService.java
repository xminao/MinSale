package pers.minho.service;

import java.util.List;

import pers.minho.dao.UserDao;
import pers.minho.entity.User;

public class UserService {
	private UserDao dao = new UserDao();

	public boolean addUser(User user) {
		return dao.addUser(user);
	}

	public boolean updateUser(User user) {
		return dao.updateUser(user);
	}

	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	public User findByNickname(String nickname) {
		return dao.findByNickname(nickname);
	}

	public List<User> findAll() {
		return dao.findAll();
	}

	public List<User> findAllByKeyword(String keyword) {
		return dao.findAllbyKeyword(keyword);
	}
}
