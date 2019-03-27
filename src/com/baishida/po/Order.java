package com.baishida.po;

public class Order {
	private int id;
	private String userid;
	private String mealid;
	private String mealsum;
	private String times;
	private String delivery;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMealid() {
		return mealid;
	}
	public void setMealid(String mealid) {
		this.mealid = mealid;
	}
	public String getMealsum() {
		return mealsum;
	}
	public void setMealsum(String mealsum) {
		this.mealsum = mealsum;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public Order(int id, String userid, String mealid, String mealsum, String times, String delivery) {
		super();
		this.id = id;
		this.userid = userid;
		this.mealid = mealid;
		this.mealsum = mealsum;
		this.times = times;
		this.delivery = delivery;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userid=" + userid + ", mealid=" + mealid + ", mealsum=" + mealsum + ", times="
				+ times + ", delivery=" + delivery + "]";
	}
	
}

