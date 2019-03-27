package com.baishida.dao;

import com.baishida.po.Admin;
import com.baishida.po.User;

public interface UserDao {
	//登陆
	public User logn(String name,String pwd);
	
	public int addUser(User user);
	
	public int update(User user);
}
