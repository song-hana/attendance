package com.my.attendance.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.attendance.domain.PublicNotice;

public interface PublicNoticeDao { 
	List<PublicNotice> selectPublicNoticeLists();
	PublicNotice selectPublicNoticeDetail(int publicNoticeNo);
	int insertPublicNotice(String pubntcTitle, String pubntcContent, LocalDate pubntcDate);
	int updatePublicNotice(PublicNotice publicNotice);
	int deletePublicNotice(int publicNoticeNo);
}
