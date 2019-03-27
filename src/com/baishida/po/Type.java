package com.baishida.po;
//Type表对应的实体类
public class Type {

	
	
	//属性
	private int id;
	private String name;
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
	
	
	//有参构造
	public Type(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	//无参构造
	public Type() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + "]";
	}
	
	
}
