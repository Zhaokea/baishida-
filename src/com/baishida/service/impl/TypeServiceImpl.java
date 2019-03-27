package com.baishida.service.impl;

import java.util.List;

import com.baishida.dao.TypeDao;
import com.baishida.dao.impl.TypeDaoImpl;
import com.baishida.po.Type;
import com.baishida.service.TypeService;

public class TypeServiceImpl implements TypeService {

	//创建Dao对象(全局)
	private TypeDao typeDao = new TypeDaoImpl();//接口，不能实体化，因此用他的实现类
	
	//获取所有的类别
	@Override
	public List<Type> getAllType() {
//		//创建Dao对象(局部)
//		TypeDao typeDao = new TypeDaoImpl();//接口，不能实体化，因此用他的实现类
		List<Type> list = typeDao.getAllType();
		
		return list;
	}

	//添加类别
	
	@Override
	public int addType(String name) {

		//创建Dao对象(使用全局)
		
		return typeDao.addType(name);
	}

	
	
	//根据id获取类别
	@Override
	public Type selectById(int id) {
		
		return typeDao.selectById(id);
	}

	//更新
	@Override
	public int update(Type type) {

		return typeDao.update(type);
	}

	//删除
	@Override
	public int deleteType(int id) {
		
		return typeDao.deleteType(id);
	}

}














