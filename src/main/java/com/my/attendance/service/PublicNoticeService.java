package com.my.attendance.service;

import java.time.LocalDate;
import java.util.List;

import com.my.attendance.domain.PublicNotice;

public interface PublicNoticeService {
	List<PublicNotice> getPublicNoticeLists();
	PublicNotice getPublicNoticeDetail(int publicNoticeNo);
	int addPublicNotice(String pubntcTitle, String pubntcContent, LocalDate pubntcDate);
	int fixPublicNotice(PublicNotice publicNotice);
	int delPublicNotice(int publicNoticeNo);
}
