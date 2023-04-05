package com.my.attendance.service;

import java.time.LocalDate;
import java.util.List;

import com.my.attendance.domain.PublicNotice;

public interface PublicNoticeService {
	List<PublicNotice> getPublicNoticeLists();
	List<PublicNotice> getPublicNotice(int publicNoticeNo);
	PublicNotice getPublicNoticeDetail(int publicNoticeNo);
	int addPublicNotice(String publicNoticeTitle, String publicNoticeContent, LocalDate publicNoticeDate);
	int fixPublicNotice(PublicNotice publicNotice);
	int delPublicNotice(int publicNoticeNo);
}
