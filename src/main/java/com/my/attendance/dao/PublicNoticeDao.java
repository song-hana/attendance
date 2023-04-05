package com.my.attendance.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.attendance.domain.PublicNotice;

public interface PublicNoticeDao { 
	List<PublicNotice> selectPublicNoticeLists();
	List<PublicNotice> selectPublicNotice(int publicNoticeNo);
	PublicNotice selectPublicNoticeDetail(int publicNoticeNo);
	int insertPublicNotice(String publicNoticeTitle, String publicNoticeContent, LocalDate publicNoticeDate);
	int updatePublicNotice(PublicNotice publicNotice);
	int deletePublicNotice(int publicNoticeNo);
}
