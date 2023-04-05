package com.my.attendance.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	public PublicNotice detailPublicNotice(int publicNoticeNo) {
		return publicNoticeMap.detailPublicNotice(publicNoticeNo);
	}
	
	@Override
	public void insertPublicNotice(String publicNoticeTitle, String publicNoticeContent, 
														LocalDate publicNoticeDate) {
		publicNoticeMap.insertPublicNotice(publicNoticeTitle, publicNoticeContent,
																publicNoticeDate);
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
