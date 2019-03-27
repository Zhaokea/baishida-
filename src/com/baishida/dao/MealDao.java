package com.baishida.dao;

import com.baishida.po.Meal;
import com.baishida.po.Menu;
import com.baishida.util.Page;

public interface MealDao {

	//根据ID获取菜单
		public Meal selectById(int id);
		
	//根据病名获取菜单
	public Meal searchByFname(String fname);
	
	//分页查询菜单
	public Page getMealByPage(Page page);//通过page传两个参数：当前页，一页多少条
		
	//分页查询菜单
	public Page getMealByPageFname(Page page,String fname);
	
	public int addMeal(Meal meal);
}
