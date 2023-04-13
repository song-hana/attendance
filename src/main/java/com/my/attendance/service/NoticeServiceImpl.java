package com.my.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.attendance.dao.PublicNoticeDao;
import com.my.attendance.domain.PublicNotice;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired private PublicNoticeDao publicNoticeDao;
	
	@Override
	public List<PublicNotice> getPublicNoticeLists(){
		return publicNoticeDao.selectPublicNoticeLists();
	}
	
	@Override
	public List<PublicNotice> getPublicNotice(int publicNoticeNo) {
		return publicNoticeDao.selectPublicNotice(publicNoticeNo);
	}
	
	@Override
	public void addPublicNotice(String publicNoticeTitle, String publicNoticeContent) {
		publicNoticeDao.insertPublicNotice(publicNoticeTitle, publicNoticeContent);
	}
	
	@Override
	public void fixPublicNotice(PublicNotice publicNotice) {
		publicNoticeDao.updatePublicNotice(publicNotice);
	}
	
	@Override
	public void delPublicNotice(int publicNoticeNo) {
		publicNoticeDao.deletePublicNotice(publicNoticeNo);
	}
}
