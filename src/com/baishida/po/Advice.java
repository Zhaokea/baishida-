package com.baishida.po;
public class Advice {

	private int id;
	private String name;
	private String yes;
	private String no;
	private String jianjie;
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
	public Advice(int id, String name, String yes, String no, String jianjie) {
		super();
		this.id = id;
		this.name = name;
		this.yes = yes;
		this.no = no;
		this.jianjie = jianjie;
	}
	public Advice() {
		super();
	}
	@Override
	public String toString() {
		return "Advice [id=" + id + ", name=" + name + ", yes=" + yes + ", no=" + no + ", jianjie=" + jianjie + "]";
	}
	

}
