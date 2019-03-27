package com.baishida.dao;

import com.baishida.po.Order;
import com.baishida.po.OrderCriteria;
import com.baishida.util.Page;
import com.baishida.vo.OrderInfo;

/**
 * 订单表操作
 * @author administrator
 *
 */


public interface OrderDao {
//insert into orders(userid,menuid,menusum,times,delivery) values(?,?,?,sysdate(),0)
	//添加一条记录
	int addOrder(Order order) throws Exception;
	
	
	//分页查询订单
	//参数：Page--》（当前页，一页几条）
	//返回值：Page
	Page queryOrderByPage(Page page,OrderCriteria criteria);
	
	
	//根据订单id删除订单delete from orders wehere id=?
	//参数：订单id
	//返回值：受影响的行数
	int deleteOrderById (int orderId);
	
	//根据订单id修改订单update orders set delivery= 1 where id = ？ 
	//参数：订单id
	//返回值：受影响的行数
	int updateOrderById (int orderId);
	//本日销售额统计
	public Page sumOrderByPage(Page page);
	
	//分页查询订单
	public Page queryOrderByDelivery(Page page,OrderCriteria criteria);
	public Page queryOrderByDelivery1(Page page,OrderCriteria criteria);
	
}
















