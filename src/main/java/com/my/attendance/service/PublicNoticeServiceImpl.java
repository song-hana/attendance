package com.my.attendance.service;

import java.time.LocalDate;
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
	public List<PublicNotice> getPublicNotice(int publicNoticeNo){
		return publicNoticeDao.selectPublicNotice(publicNoticeNo);
	}
	
	@Override
	public PublicNotice getPublicNoticeDetail(int publicNoticeNo) {
		return publicNoticeDao.selectPublicNoticeDetail(publicNoticeNo);
	}
	
	@Override
	public int addPublicNotice(String publicNoticeTitle, String publicNoticeContent, 
													LocalDate publicNoticeDate) {
		return publicNoticeDao.insertPublicNotice(publicNoticeTitle, publicNoticeContent, publicNoticeDate);
	}
	
	@Override
	public int fixPublicNotice(PublicNotice publicNotice) {
		return publicNoticeDao.updatePublicNotice(publicNotice);
	}
	
	@Override
	public int delPublicNotice(int publicNoticeNo) {
		return publicNoticeDao.deletePublicNotice(publicNoticeNo);
	}
}
