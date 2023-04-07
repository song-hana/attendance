package com.my.attendance.service;

import java.util.List;

import com.my.attendance.domain.PublicNotice;

public interface PublicNoticeService {
	List<PublicNotice> getPublicNoticeLists();
	PublicNotice getPublicNoticeDetail(int publicNoticeNo);
	void addPublicNotice(String pubntcTitle, String pubntcContent);
	void fixPublicNotice(PublicNotice publicNotice);
	void delPublicNotice(int publicNoticeNo);
}
