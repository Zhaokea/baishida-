package com.baishida.dao.impl;

import java.util.List;

import com.baishida.dao.TypeDao;
import com.baishida.po.Type;
import com.baishida.util.DBUtil;

public  class TypeDaoImpl implements TypeDao {
	
	//3.创建DBUtil对象（全局）(添加private 更安全)
	private DBUtil dbUtil = new DBUtil();
	
	
	//获取所有类别
	
	@Override
	public List<Type> getAllType() {

		//5.
		List list = null;
		
		//1.sql语句
		String sql = "select * from types";
		//2.组织参数（无参，略）
//		//3.创建DBUtil对象（局部）
//		DBUtil dbUtil = new DBUtil();
		//4.调用获取list的方法
		try {
			list = dbUtil.getQueryList(Type.class, sql, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	//添加类别
	
	@Override
	public int addType(String name) {
		
		int i =0; //int 默认值为0
		
		//1.sql语句
		String sql ="insert into types (name) values (?)";
		//2.组织参数
		Object[] params ={name};
		//3.创建DBUtil对象(使用全局量)
		//调用工具类中的添加方法
		try {
			i = dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	
	//根据id获取类别
	@Override
	public Type selectById(int id) {
		
		Type type = null;
		
		//1.写sql语句
		String sql = "select * from types where id = ?";
				
		//2.组织参数
		Object[] params = {id};
		//3.创建DBUtil对象(使用全局量)
		
		//4.调用工具类方法完成查询
		try {
			type = (Type)dbUtil.getObject(Type.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return type;
	}

	
	//更新
	@Override
	public int update(Type type) {
		
		int i = 0;
		
		//1.sql语句
		String sql = "update types set name = ? where id = ?";
		//组织参数
		Object[] params = {type.getName(),type.getId()};
		//调用工具类中的方法更新
		try {
			i = dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
	}

	
	
	//删除
	@Override
	public int deleteType(int id) {
		int i =0;
		
		//1.sql
		String sql = "delete from types where id = ?";
		
		//2.组织参数
		Object[] params = {id};
		
		try {
			i = dbUtil.execute(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}






















