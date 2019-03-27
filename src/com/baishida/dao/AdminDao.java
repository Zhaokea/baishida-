package com.baishida.dao;

import com.baishida.po.Admin;


//接口

public interface AdminDao {
	//登陆
	//写方法，明确返回值和参数列表
	public Admin login(String name,String pwd);//接口中的抽象方法
	
	//修改
	public int updateAdmin(String name,String pwd,int id);
}
