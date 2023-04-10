package com.my.attendance.dao;

import java.util.List;

import com.my.attendance.domain.PublicNotice;

public interface PublicNoticeDao { 
	List<PublicNotice> selectPublicNoticeLists();
	List<PublicNotice> selectPublicNoticeDetail(int publicNoticeNo);
	void insertPublicNotice(String pubntcTitle, String pubntcContent);
	void updatePublicNotice(PublicNotice publicNotice);
	void deletePublicNotice(int publicNoticeNo);
}
