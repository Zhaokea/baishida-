package com.baishida.service.impl;

import com.baishida.dao.MenuDao;
import com.baishida.dao.impl.MenuDaoImpl;
import com.baishida.po.Meal;
import com.baishida.po.Menu;
import com.baishida.service.MenuService;
import com.baishida.util.Page;

public class MenuServiceImpl implements MenuService {

	//创建Dao层对象
	private MenuDao menuDao = new MenuDaoImpl();
	
	@Override
	public Page getMenuByPage(Page page) {
		

		
		Page curpage = menuDao.getMenuByPage(page);
		
		return curpage;
	}
	//添加
	@Override
	public int addMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.addMenu(menu);
	}
	//查找
	@Override
	public Menu selectById(int id) {
		// TODO Auto-generated method stub
		return menuDao.selectById(id);
	}
	//删除
	@Override
	public int deleteMenu(int id) {
		// TODO Auto-generated method stub
		return menuDao.deleteMenu(id);
	}
	
	//更新
	@Override
	public int update(Meal meal) {
		// TODO Auto-generated method stub
		return menuDao.update(meal);
	}

}
