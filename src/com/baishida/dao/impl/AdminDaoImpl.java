package com.baishida.dao.impl;

import com.baishida.dao.AdminDao;
import com.baishida.po.Admin;
import com.baishida.util.DBUtil;


//实现接口

public class AdminDaoImpl implements AdminDao{

	//登陆
	@Override
	public Admin login(String name, String pwd) {
		//5.
		Admin admin = null;
		
		//1.写sql语句
		String sql = "select * from admin where name = ? and pwd = ?";
		//2.组织参数(给占位符？赋值)
		Object[] params = {name,pwd};
		//3.创建工具类DBUtil对象
		DBUtil dbutil = new DBUtil();
		//4.调用工具类的方法
		try {
			//去数据库里查找匹配的方法getObject
			//（Admin）强制转换为Admin类型
			admin = (Admin)dbutil.getObject(Admin.class, sql, params);//提示会有异常，用Try.catch包围
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
		
		
	}

	@Override
	public int updateAdmin(String name, String pwd,int id) {

		int i = 0;
		String sql = "update admin set name = ? , pwd=?  where id = ?";
		//2.组织参数(给占位符？赋值)
		Object[] params = {name,pwd,id};
		//3.创建工具类DBUtil对象
		DBUtil dbutil = new DBUtil();
		
		try {
			i =dbutil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
