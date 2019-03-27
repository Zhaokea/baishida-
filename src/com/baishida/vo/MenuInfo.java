package com.baishida.vo;
//menu信息列表对应的值对象
public class MenuInfo {

	private int id;
	private String name;
	private String typename;
	private String burden;
	private String brief;
	private String price;
	private String sums;
	private String price1;
	private String sums1;
	private String imgpath;
	private String yes;
	private String no;
	private String jianjie;
	
	
	public MenuInfo(int id, String name, String typename, String burden, String brief, String price, String sums,
			String price1, String sums1, String imgpath, String yes, String no, String jianjie) {
		super();
		this.id = id;
		this.name = name;
		this.typename = typename;
		this.burden = burden;
		this.brief = brief;
		this.price = price;
		this.sums = sums;
		this.price1 = price1;
		this.sums1 = sums1;
		this.imgpath = imgpath;
		this.yes = yes;
		this.no = no;
		this.jianjie = jianjie;
	}
	public String getYes() {
		return yes;
	}
	public void setYes(String yes) {
		this.yes = yes;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getJianjie() {
		return jianjie;
	}
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
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
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getBurden() {
		return burden;
	}
	public void setBurden(String burden) {
		this.burden = burden;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSums() {
		return sums;
	}
	public void setSums(String sums) {
		this.sums = sums;
	}
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price1) {
		this.price1 = price1;
	}
	public String getSums1() {
		return sums1;
	}
	public void setSums1(String sums1) {
		this.sums1 = sums1;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	

	
	public MenuInfo() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "MenuInfo [id=" + id + ", name=" + name + ", typename=" + typename + ", burden=" + burden + ", brief="
				+ brief + ", price=" + price + ", sums=" + sums + ", price1=" + price1 + ", sums1=" + sums1
				+ ", imgpath=" + imgpath + ", yes=" + yes + ", no=" + no + ", jianjie=" + jianjie + "]";
	}
	
	
}
