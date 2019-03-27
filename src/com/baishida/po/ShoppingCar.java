package com.baishida.po;

public class ShoppingCar {
	
	private int mealId;
	private String name;//商品名
	private float price;//商品价格
	private int sums;//商品数量
	
	public int getMealId() {
		return mealId;
	}
	public void setMealId(int mealId) {
		this.mealId = mealId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getSums() {
		return sums;
	}
	public void setSums(int sums) {
		this.sums = sums;
	}
	public ShoppingCar(int mealId, String name, float price, int sums) {
		super();
		this.mealId = mealId;
		this.name = name;
		this.price = price;
		this.sums = sums;
	}
	public ShoppingCar() {
		super();
	}
	
}
