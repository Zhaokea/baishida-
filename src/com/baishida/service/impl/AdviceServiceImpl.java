package com.baishida.service.impl;

import com.baishida.dao.AdviceDao;
import com.baishida.dao.impl.AdviceDaoImpl;
import com.baishida.po.Advice;
import com.baishida.service.AdviceService;

public class AdviceServiceImpl implements AdviceService {
	AdviceDao adviceDao=new AdviceDaoImpl();
	@Override
	public Advice selectAdviceById(int id) {
		// TODO Auto-generated method stub
		return adviceDao.selectAdviceById(id);
	}

}
