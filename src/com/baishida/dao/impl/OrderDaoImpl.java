package com.baishida.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.baishida.dao.OrderDao;
import com.baishida.po.Order;
import com.baishida.po.OrderCriteria;
import com.baishida.util.DBUtil;
import com.baishida.util.Page;
import com.baishida.vo.OrderInfo;

public class OrderDaoImpl implements OrderDao {

	private DBUtil dbUtil = new DBUtil();
	@Override
	public int addOrder(Order order) throws Exception {
		String sql = "insert into orders(userid,mealid,mealsum,times,delivery) values(?,?,?,sysdate(),'0')";
		Object[] params = {order.getUserid(),order.getMealid(),order.getMealsum()};
		int rows = dbUtil.execute(DBUtil.getConnection(),sql, params);

		return rows;
	}
	@Override
	public Page queryOrderByPage(Page page,OrderCriteria criteria) {

		//sql
		StringBuffer sql = new StringBuffer();
		sql.append("select o.id orderId,u.id userId,u.realname realName,u.phone,u.address,")
			.append("m.name meunName,o.mealsum meunSum,m.price price1,o.times,o.delivery")
			.append(" from orders o")
			.append(" INNER JOIN users u on o.userid = u.id")
			.append(" INNER JOIN meal m on o.mealid = m.id where u.id=1");
		

		List<Object> params = new ArrayList<Object>();
		
		if(criteria!=null)
		{
			//有查询条件
			//获取四个条件
			int userId = criteria.getUserId();
			if(userId>0)
			{
				//拼接sql
				sql.append(" and u.id=?");
				params.add(userId);
			}
			String menuName = criteria.getMenuName();
			if(menuName!=null&&!"".equals(menuName.trim())){
				sql.append(" and m.name like ?");
				params.add("%"+menuName+"%");
			}
			String date = criteria.getDate();
			if(date!=null&&!"".equals(date.trim())){
				sql.append(" and o.times like ?");
				params.add("%"+date+"%");
			}
			int delivery = criteria.getDelivery();
			if(delivery!=-1){
				sql.append(" and o.delivery = ?");
				params.add(delivery);
			}
			
			//根据查询条件中的内容来动态的生成sql
		}
		sql.append(" ORDER BY o.times desc");
		try {
			page = dbUtil.getQueryPage(OrderInfo.class, sql.toString(), params.toArray(), page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;

	}
	@Override
	public int deleteOrderById(int orderId) {


		int rows = 0;
		String sql = "delete from orders where id=?";
		Object [] params ={orderId};
		try {
			rows =dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	
	@Override
	public int updateOrderById(int orderId) {
		int rows = 0;
		String sql = "update orders set delivery= '1' where id =?";
		Object [] params ={orderId};
		try {
			rows =dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return rows;
	}
	
	
	
	
	@Override
	public Page sumOrderByPage(Page page) {
		
		StringBuffer sql = new StringBuffer();
		sql	.append("select CAST(sum(o.mealsum) AS char) menuSum,m.name menuName,m.price price1")
			.append(" from orders o")
			.append(" INNER JOIN meal m on o.menuid = m.id where 1=1")
			.append(" group by mealName");
		
		try {
			page = dbUtil.getQueryPage(OrderInfo.class, sql.toString(), null, page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return page;
	}
	
	
	@Override
	public Page queryOrderByDelivery(Page page, OrderCriteria criteria) {
		// 1.构建sql
				StringBuffer sql = new StringBuffer();
				sql.append(
						"select o.id orderId,u.id userId,u.realname realName,u.phone,u.address,m.name menuName,o.menusum menuSum,m.price1,o.times,o.delivery")
						.append(" from orders o").append(" INNER JOIN users u on o.userid = u.id")
						.append(" INNER JOIN menus m on o.menuid = m.id where delivery = 0");
				List<Object> params = new ArrayList<Object>();
				if(criteria!=null)
				{
					//有查询条件
					//获取四个条件
					int userId = criteria.getUserId();
					if(userId>0)
					{
						//拼接sql
						sql.append(" and u.id=?");
						params.add(userId);
					}
				}
				
					//根据查询条件中的内容来动态的生成sql
				sql.append(" ORDER BY o.times desc");
				try {
					page = dbUtil.getQueryPage(OrderInfo.class, sql.toString(), params.toArray(), page);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return page;
	}

	@Override
	public Page queryOrderByDelivery1(Page page, OrderCriteria criteria) {
		// 1.构建sql
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select o.id orderId,u.id userId,u.realname realName,u.phone,u.address,m.name menuName,o.menusum menuSum,m.price1,o.times,o.delivery")
				.append(" from orders o").append(" INNER JOIN users u on o.userid = u.id")
				.append(" INNER JOIN menus m on o.menuid = m.id where delivery = 1");
		
		List<Object> params = new ArrayList<Object>();
		if(criteria!=null)
		{
			//有查询条件
			//获取四个条件
			int userId = criteria.getUserId();
			if(userId>0)
			{
				//拼接sql
				sql.append(" and u.id=?");
				params.add(userId);
			}
		}
			//根据查询条件中的内容来动态的生成sql
		sql.append(" ORDER BY o.times desc");
		try {
			page = dbUtil.getQueryPage(OrderInfo.class, sql.toString(), params.toArray(), page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}


}

















