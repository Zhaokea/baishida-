package com.baishida.po;

public class Meal {
	
	private int id;
	private String name;
	private String imgpath;
	private String price;
	private String burden;
	private String make;
	private String fname;
	private String f;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBurden() {
		return burden;
	}
	public void setBurden(String burden) {
		this.burden = burden;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	
	
	
	public Meal(int id, String name, String imgpath, String price, String burden, String make, String fname, String f) {
		super();
		this.id = id;
		this.name = name;
		this.imgpath = imgpath;
		this.price = price;
		this.burden = burden;
		this.make = make;
		this.fname = fname;
		this.f = f;
	}
	
	
	public Meal() {
		super();
	}

	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	
	@Override
	public String toString() {
		return "Meal [id=" + id + ", name=" + name + ", imgpath=" + imgpath + ", price=" + price + ", burden=" + burden
				+ ", make=" + make + ", fname=" + fname + ", f=" + f + "]";
	}
	
	
}
