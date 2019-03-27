package com.baishida.service.impl;

import com.baishida.dao.UserDao;
import com.baishida.dao.impl.UserDaoImpl;
import com.baishida.po.User;
import com.baishida.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	@Override
	public User logn(String name, String pwd) {
		
		return userDao.logn(name, pwd);
	}
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}
	@Override
	public int update(User user) {
		return userDao.update(user);
	}

}
