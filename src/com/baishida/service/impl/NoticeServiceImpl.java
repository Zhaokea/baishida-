package com.baishida.service.impl;

import java.util.List;

import com.baishida.dao.NoticeDao;
import com.baishida.dao.impl.NoticeDaoImpl;
import com.baishida.po.Notice;
import com.baishida.po.Type;
import com.baishida.service.NoticeService;
import com.sun.jmx.remote.security.NotificationAccessController;

public class NoticeServiceImpl implements NoticeService {

	//鍒涘缓Dao瀵硅薄
	private NoticeDao noticeDao = new NoticeDaoImpl();
	
	//鑾峰彇鎵�鏈夌殑閫氬憡
	@Override
	public List<Notice> getAllNotice() {
		List<Notice> list = noticeDao.getAllNotice();
		return list;
	}

	
	//鍒犻櫎
	@Override
	public int deleteNotice(int id) {
		
		return noticeDao.deleteNotice(id);
	}

	//娣诲姞
	@Override
	public int addNotice(String name, String content) {
		
		return noticeDao.addNotice(name, content);
	}

	@Override
	public int addNotice2(Notice notice) {
		
		return noticeDao.addNotice2(notice);
	}


	@Override
	public Notice selectNoticeById(int id) {
		// TODO Auto-generated method stub
		return noticeDao.selectNoticeById(id);
	}

}
