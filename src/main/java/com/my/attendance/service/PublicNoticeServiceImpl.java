package com.my.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.attendance.dao.PublicNoticeDao;
import com.my.attendance.domain.PublicNotice;

@Service
public class PublicNoticeServiceImpl implements PublicNoticeService { 
	@Autowired private PublicNoticeDao publicNoticeDao;
	
	@Override
	public List<PublicNotice> getPublicNoticeLists(){
		return publicNoticeDao.selectPublicNoticeLists();
	}
	
	@Override
	public PublicNotice getPublicNoticeDetail(int publicNoticeNo) {
		return publicNoticeDao.selectPublicNoticeDetail(publicNoticeNo);
	}
	
	@Override
	public void addPublicNotice(String pubntcTitle, String pubntcContent) {
		 publicNoticeDao.insertPublicNotice(pubntcTitle, pubntcContent);
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
