package com.my.attendance.service;

import java.util.List;

import com.my.attendance.domain.PublicNotice;

public interface NoticeService {
	List<PublicNotice> getPublicNoticeLists();
	List<PublicNotice> getPublicNotice(int publicNoticeNo);
	void addPublicNotice(String publicNoticeTitle, String publicNoticeContent);
	void fixPublicNotice(PublicNotice publicNotice);
	void delPublicNotice(int publicNoticeNo);
}
