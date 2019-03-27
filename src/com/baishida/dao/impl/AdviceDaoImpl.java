package com.baishida.dao.impl;

import com.baishida.dao.AdviceDao;
import com.baishida.po.Advice;
import com.baishida.util.DBUtil;

public class AdviceDaoImpl implements AdviceDao {
	private	DBUtil dbUtil =new DBUtil();

	@Override
	public Advice selectAdviceById(int id) {
		Advice advice=null;
		//写sql语句
		String sql="select * from advice where id=?";
		//组织参数
		Object[] params={id}; 
		//调用工具类方法完成查询
		try {
			advice =(Advice)dbUtil.getObject(Advice.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advice;
	}

}
