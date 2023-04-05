package com.my.attendance.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.my.attendance.domain.PublicNotice;

public interface PublicNoticeDao { 
	List<PublicNotice> selectPublicNoticeLists();
	PublicNotice detailPublicNotice(@Param("publicNoticeNo") int publicNoticeNo);
	void insertPublicNotice(@Param("publicNoticeTitle") String publicNoticeTitle,
								@Param("publicNoticeContent") String publicNoticeContent,
									@Param("publicNoticeDate") LocalDate publicNoticeDate);
	void updatePublicNotice(PublicNotice publicNotice);
	void deletePublicNotice(int publicNoticeNo);
}
