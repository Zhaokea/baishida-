package com.baishida.dao;

import java.util.List;

import com.baishida.po.Type;

public interface TypeDao {

	
	//获取所有的类别
	public List<Type> getAllType();
	
	//添加类别
	public int addType(String name);
	
	//根据id获取类别
	public Type selectById(int id);
	
	//更新
	public int update(Type type);
	
	//删除
	public int deleteType(int id);
}
