package com.baishida.dao.impl;

import com.baishida.dao.MenuDao;
import com.baishida.po.Meal;
import com.baishida.po.Menu;
import com.baishida.util.DBUtil;
import com.baishida.util.Page;
import com.baishida.vo.MenuInfo;

public class MenuDaoImpl implements MenuDao {
	
	
	

	private DBUtil dbUtil = new DBUtil();
	
	
	
	@Override
	public Page getMenuByPage(Page page) {
		
		
		//写sql,给menus表别名m，types别名t
		String sql = "select m.id , m.name , t.name as typename, m.burden , "
				+ "m.brief , m.price , m.sums , m.price1 , m.sums1 , m.imgpath"
				+ " from menus m ,types t where m.typeid=t.id";
		//调用工具类中的分页查询方法
		Page curPage= dbUtil.getQueryPage(MenuInfo.class, sql, null, page);
		
		return curPage;
	}


	//添加

	@Override
	public int addMenu(Menu menu) {
		int i =0;
		String sql = "insert into menus(name,typeid,burden,brief,price,price1,imgpath) values (?,?,?,?,?,?,?)";
		
		Object[] params = {menu.getName(),menu.getTypeid(),menu.getBurden(),menu.getBrief(),menu.getPrice(),menu.getPrice1(),menu.getImgpath()};
		
		try {
			i = dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}


	//根据ID获取菜单
	@Override
	public Menu selectById(int id){
		Menu i = null;
		String sql = "select * from menus where id=?";
		Object[] params ={id};
		try {
			i = (Menu)dbUtil.getObject(Menu.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//删除
	@Override
	public int deleteMenu(int id) {
		int i=0;
		String sql = "delete from menus where id=?";
		Object[] params = {id};
		try {
			i = dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//修改
	@Override
	public int update(Meal meal) {
		
		int i = 0;
		
		//1.sql语句
		String sql = "update meal set name = ? , burden=?,make=?,price=? where id = ?";
		//组织参数
		Object[] params = {meal.getName(),meal.getBurden(),meal.getMake(),meal.getPrice(),meal.getId()};
		//调用工具类中的方法更新
		try {
			i = dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

}












