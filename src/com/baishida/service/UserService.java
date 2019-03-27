package com.baishida.service;

import com.baishida.po.User;

public interface UserService {

	//登陆
	public User logn(String name,String pwd);
	
	
	public int addUser(User user);
	
	public int update(User user);
}
