package com.baishida.po;

import java.util.Date;

//通知的实体类

public class Notice {
	//属性
	private int id;
	private String name;
	private String content;
	private String times;
	
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	
	
	public Notice(int id, String name, String content, String times) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.times = times;
	}
	
	public Notice() {
		super();
	}
	
	@Override
	public String toString() {
		return "Notice [id=" + id + ", name=" + name + ", content=" + content + ", times=" + times + "]";
	}
	
}
