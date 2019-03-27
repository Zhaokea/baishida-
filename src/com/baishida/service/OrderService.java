package com.baishida.service;

import com.baishida.po.OrderCriteria;
import com.baishida.po.ShoppingCar;
import com.baishida.util.Page;
import com.baishida.vo.OrderInfo;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import java.util.List;

public interface OrderService {
	
	 //下单的方法
	//参数：购物车、用户id
	//返回值：boolean
boolean addOrder (List<ShoppingCar> carList,String userId);
	
	//分页查询订单
	Page queryOrderByPage(Page page,OrderCriteria criteria);

	//根据订单id删除订单delete from orders wehere id=?
	//参数：订单id
	//返回值：受影响的行数
	boolean deleteOrderById (int orderId);
		
	//根据订单id修改订单update orders set delivery= 1 where id = ？ 
	//参数：订单id
	//返回值：受影响的行数
	boolean updateOrderById (int orderId);
	
	//本日销售额统计
	public Page sumOrderByPage(Page page);
	
	
	public Page queryOrderByDelivery(Page page,OrderCriteria criteria);
	public Page queryOrderByDelivery1(Page page,OrderCriteria criteria);
}
