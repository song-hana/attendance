package com.my.attendance.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.attendance.dao.map.PublicNoticeMap;
import com.my.attendance.domain.PublicNotice;

@Repository
public class PublicNoticeDaoImpl implements PublicNoticeDao { 
	@Autowired private PublicNoticeMap publicNoticeMap;
	
	@Override
	public List<PublicNotice> selectPublicNoticeLists(){
		return publicNoticeMap.selectPublicNoticeLists();
	}
	
	@Override
	public List<PublicNotice> selectPublicNoticeDetail(int publicNoticeNo) {
		return publicNoticeMap.selectPublicNoticeDetail(publicNoticeNo);
	}
	
	@Override
	public void insertPublicNotice(String pubntcTitle, String pubntcContent) {
		publicNoticeMap.insertPublicNotice(pubntcTitle, pubntcContent);
	}
	
	@Override
	public void updatePublicNotice(PublicNotice publicNotice) {
		publicNoticeMap.updatePublicNotice(publicNotice);
	}
	
	@Override
	public void deletePublicNotice(int publicNoticeNo) {
		publicNoticeMap.deletePublicNotice(publicNoticeNo);
	}
}
