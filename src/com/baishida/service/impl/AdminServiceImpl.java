package com.baishida.service.impl;

import com.baishida.dao.AdminDao;
import com.baishida.dao.impl.AdminDaoImpl;
import com.baishida.po.Admin;
import com.baishida.service.AdminService;

public class AdminServiceImpl implements AdminService {

	@Override
	public Admin login(String name, String pwd) {
		
		//先创建AdminDao一个对象来调用login登录方法
		AdminDao adminDao = new AdminDaoImpl();//多态；Admin是接口，不能实体化，因此用他的实现类AdminDaoImpl
		Admin admin = adminDao.login(name, pwd);
		
		return admin;
	}

	@Override
	public int updateAdmin(String name, String pwd, int id) {
		AdminDao adminDao = new AdminDaoImpl();
		return adminDao.updateAdmin(name,pwd,id);
	}

}
