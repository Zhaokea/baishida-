package com.baishida.dao;

import com.baishida.po.Meal;
import com.baishida.po.Menu;
import com.baishida.util.Page;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public interface MenuDao {

	
	//分页查询菜单
	public Page getMenuByPage(Page page);//通过page传两个参数：当前页，一页多少条
	//添加
	public int addMenu(Menu menu);
	
	//根据ID获取菜单
	public Menu selectById(int id);
	
	//删除
	public int deleteMenu(int id);
	
	//更新
	public int update(Meal meal);

}
