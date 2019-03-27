package com.baishida.dao.impl;

import java.util.List;

import com.baishida.dao.NoticeDao;
import com.baishida.po.Menu;
import com.baishida.po.Notice;
import com.baishida.util.DBUtil;

public class NoticeDaoImpl implements NoticeDao {

	
	
	//获取所有的通告
	@Override
	public List<Notice> getAllNotice() {
		
		List list = null;
		
		//1.sql语句
		String sql = "select * from notice";
		//2.组织参数（无参，略）
		//3.创建DBUtil对象
		DBUtil dbUtil = new DBUtil();
		//4.调用获取list的方法
		try {
			 list = dbUtil.getQueryList(Notice.class, sql, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	
	//删除
	@Override
	public int deleteNotice(int id) {
		
		int i =0;
		
		String sql ="delete from notice where id = ?";
				
		DBUtil dbUtil = new DBUtil();
		
		Object[] params = {id};
		
		try {
			i = dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	//直接传参添加，方法为addNotice
	@Override
	public int addNotice(String name,String content) {
		int i =0;
		
		String sql = "insert into notice (name,content,times) values (?,?,SYSDATE())";
		DBUtil dbUtil = new DBUtil();
		Object[] params = {name,content};
		
		try {
			i = dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//使用封装参数添加,方法为addNotice2
	@Override
	public int addNotice2(Notice notice) {
		int i =0;
		
		String sql = "insert into notice (name,content,times) values (?,?,SYSDATE())";
		DBUtil dbUtil = new DBUtil();
		Object[] params = {notice.getName(),notice.getContent()};

		
		try {
			i = dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}


	@Override
	public Notice selectNoticeById(int id) {
		Notice i = null;
		String sql = "select * from notice where id=?";
		DBUtil dbUtil = new DBUtil();
		Object[] params ={id};
		try {
			i = (Notice)dbUtil.getObject(Notice.class, sql, params);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return i;
	}

}
