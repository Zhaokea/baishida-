package com.baishida.dao.impl;

import com.baishida.dao.MealDao;
import com.baishida.po.Meal;
import com.baishida.po.Menu;
import com.baishida.util.DBUtil;
import com.baishida.util.Page;
import com.baishida.vo.MenuInfo;

public class MealDaoImpl implements MealDao {

	private DBUtil dbUtil = new DBUtil();
	
	
	
	@Override
	public Meal searchByFname(String fname) {
		Meal i = null;
		String sql = "select m.id , m.name , m.burden , m.price , m.make , m.imgpath from meal m ,illness i where m.fname=i.name and i.id=?";
		Object[] params ={fname};
		try {
			i = (Meal)dbUtil.getObject(Meal.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	
	//根据ID获取菜单
		@Override
		public Meal selectById(int id){
			Meal i = null;
			String sql = "select * from meal where id=?";
			Object[] params ={id};
			try {
				i = (Meal)dbUtil.getObject(Meal.class, sql, params);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}

	
	
	
	@Override
	public Page getMealByPage(Page page) {
		
		
		//写sql
		//String sql = "select id , name , imgpath , price , burden   from meal ";
		String sql = "select * from meal";
		//调用工具类中的分页查询方法
		Page curPage= dbUtil.getQueryPage(Meal.class, sql, null, page);
		
		return curPage;
	}

	
	
	@Override
	public Page getMealByPageFname(Page page, String fname) {
		//写sql
		String sql = "select m.id , m.name , m.burden , m.price , m.make , m.imgpath ,i.yes ,i.no ,i.jianjie from meal m ,cjsl i where m.fname=i.name and i.id=?";
		//调用工具类中的分页查询方法
		Object[] fname1 = {fname};
		Page curPage= dbUtil.getQueryPage(MenuInfo.class, sql, fname1, page);
				
		return curPage;
	}


	@Override
	public int addMeal(Meal meal) {
		// TODO Auto-generated method stub
		int i= 0;
		String sql = "insert into meal(name,imgpath,price,burden,make,fname) values(?,?,?,?,?,?)";
		System.out.println("*****************sql:"+sql);
		Object [] params = {meal.getName(),meal.getImgpath(),meal.getPrice(),meal.getBurden(),meal.getMake(),meal.getFname()};
		System.out.println("++++++++++++++++++++++++++++:length"+params.length);
		try {
			i = dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
