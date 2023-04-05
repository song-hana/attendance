package com.my.attendance.service;

import java.time.LocalDate;
import java.util.List;

import com.my.attendance.domain.PublicNotice;

public interface PublicNoticeService { 
	List<PublicNotice> getPublicNoticeLists();
	PublicNotice getDetailPublicNotice(int publicNoticeNo);
	void addPublicNotice(String publicNoticeTitle, String publicNoticeContent, LocalDate publicNoticeDate);
	void fixPublicNotice(PublicNotice publicNotice);
	void delPublicNotice(int publicNoticeNo);
}
