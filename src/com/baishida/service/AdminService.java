package com.baishida.service;

import com.baishida.po.Admin;

public interface AdminService {
	//管理员登陆
	public Admin login(String name,String pwd);
	
	
	//修改
	public int updateAdmin(String name,String pwd,int id);
	
}
