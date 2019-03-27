package com.baishida.service;

import java.util.List;

import com.baishida.po.Notice;

public interface NoticeService {

	//获取所有的通告
	public List<Notice> getAllNotice();
	
	//按照日期降序查询前三个通告
	//sql：order by times DESC limit(0,3)
	
	//删除
	public int deleteNotice(int id);
	
	//添加类别
	public int addNotice(String name,String content);
	
	public int addNotice2(Notice notice);
	
	//获取所有的通告
	public Notice selectNoticeById(int id);
}
