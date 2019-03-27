package com.baishida.service.impl;

import com.baishida.dao.MealDao;
import com.baishida.dao.impl.MealDaoImpl;
import com.baishida.dao.impl.MenuDaoImpl;
import com.baishida.po.Meal;
import com.baishida.po.Menu;
import com.baishida.service.MealService;
import com.baishida.util.Page;

public class MealServiceImpl implements MealService {

	//创建Dao层对象
	private MealDao mealDao = new MealDaoImpl();
	
	
	@Override
	public Meal searchByFname(String fname) {
		return mealDao.searchByFname(fname);
	}

	//查找
		@Override
		public Meal selectById(int id) {
			// TODO Auto-generated method stub
			return mealDao.selectById(id);
		}

	
	@Override
	public Page getMealByPage(Page page) {
		Page curpage = mealDao.getMealByPage(page);
		
		return curpage;
	}

	@Override
	public Page getMealByPageFname(Page page, String fname) {
		Page curpage = mealDao.getMealByPageFname(page,fname);
		
		return curpage;
	}

	@Override
	public int addMeal(Meal meal) {
		// TODO Auto-generated method stub
		return mealDao.addMeal(meal);
	}

}
