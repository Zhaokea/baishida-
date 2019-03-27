package com.baishida.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.baishida.dao.OrderDao;
import com.baishida.dao.impl.OrderDaoImpl;
import com.baishida.po.Order;
import com.baishida.po.OrderCriteria;
import com.baishida.po.ShoppingCar;
import com.baishida.service.OrderService;
import com.baishida.util.DBUtil;
import com.baishida.util.Page;
import com.baishida.vo.OrderInfo;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();
	
	@Override
	public boolean addOrder(List<ShoppingCar> carList, String userId) {


		boolean result = false;
		
		
		//循环调用OrderDao中的addOrder方法
		
		//使用事务——》保证同一连接connection
		try {
			
			DBUtil.beginTranscation();
			//遍历List《shoppingCar》--》每一个条目shoppingcar--》得到menuid
			for(ShoppingCar carItem : carList){
				
				//carItem
				//menuid,menusum,userId-->order
				int mealId = carItem.getMealId();
				int sums = carItem.getSums();
				Order order = new Order();
				order.setMealid(String.valueOf(mealId));
				order.setMealsum(String.valueOf(sums));
				order.setUserid(userId);
				//调用OrderDao中的addOrder方法
				orderDao.addOrder(order);
			}
			DBUtil.endTranscation();//提交事务
			result = true ;
						
		} catch (Exception e) {
			
			
			try {
				DBUtil.rollback();//回滚事务
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}finally {
			//关闭连接
			try {
				DBUtil.closeConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
	}

	@Override
	public Page queryOrderByPage(Page page,OrderCriteria criteria) {
		return orderDao.queryOrderByPage(page,criteria);
	}

	@Override
	public boolean deleteOrderById(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.deleteOrderById(orderId)>0;
	}

	
	
	@Override
	public boolean updateOrderById(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.updateOrderById(orderId)>0;
	}

	@Override
	public Page sumOrderByPage(Page page) {
		// TODO Auto-generated method stub
		return orderDao.sumOrderByPage(page);
	}
	
	
	
	@Override
	public Page queryOrderByDelivery(Page page, OrderCriteria criteria) {
		// TODO Auto-generated method stub
		return orderDao.queryOrderByDelivery(page,criteria);
	}
	@Override
	public Page queryOrderByDelivery1(Page page, OrderCriteria criteria) {
		// TODO Auto-generated method stub
		return orderDao.queryOrderByDelivery1(page,criteria);
	}

}







