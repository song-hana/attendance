package com.my.attendance.dao;

import java.time.LocalDate;
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
	public List<PublicNotice> selectPublicNotice(int publicNoticeNo){
		return publicNoticeMap.selectPublicNotice(publicNoticeNo);
	}
	
	@Override
	public PublicNotice selectPublicNoticeDetail(int publicNoticeNo) {
		return publicNoticeMap.selectPublicNoticeDetail(publicNoticeNo);
	}
	
	@Override
	public int insertPublicNotice(String publicNoticeTitle, String publicNoticeContent, 
														LocalDate publicNoticeDate) {
		return publicNoticeMap.insertPublicNotice(publicNoticeTitle, publicNoticeContent, publicNoticeDate);
	}
	
	@Override
	public int updatePublicNotice(PublicNotice publicNotice) {
		return publicNoticeMap.updatePublicNotice(publicNotice);
	}
	
	@Override
	public int deletePublicNotice(int publicNoticeNo) {
		return publicNoticeMap.deletePublicNotice(publicNoticeNo);
	}
}
