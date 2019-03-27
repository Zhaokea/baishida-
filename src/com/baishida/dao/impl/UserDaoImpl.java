package com.baishida.dao.impl;

import com.baishida.dao.UserDao;
import com.baishida.po.User;
import com.baishida.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User logn(String name, String pwd) {
		
		User i = null;
		String sql = "select * from users where name=? and pwd=?";
		
		Object[] params={name,pwd};
		
		DBUtil dbUtil = new DBUtil();
		
		try {
			i = (User)dbUtil.getObject(User.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}


	@Override
	public int addUser(User user) {
		int i =0;
				
		String sql = "insert into users(name,pwd,realname,sex,age,card,address,phone,email,code) values (?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {user.getName(),user.getPwd(),user.getRealname(),user.getSex(),user.getAge(),user.getCard(),user.getAddress(),user.getPhone(),user.getEmail(),user.getCode()};
		
		DBUtil dbUtil = new DBUtil();
		
		try {
			i = dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	
	@Override
	public int update(User user) {
		int i = 0;
		String sql = "update users set pwd=?,realname=?,age=?,card=?,address=?,phone=?,email=?,code=? where id =?";
		Object[] params = {user.getPwd(),user.getRealname(),user.getAge(),user.getCard(),user.getAddress(),user.getPhone(),user.getEmail(),user.getCode(),user.getId()};

		DBUtil dbUtil = new DBUtil();
		try {
			i = dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
