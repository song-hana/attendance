package com.my.attendance.dao.map;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.my.attendance.domain.PublicNotice;

public interface PublicNoticeMap {	 
	List<PublicNotice> selectPublicNoticeLists();
	PublicNotice detailPublicNotice(@Param("publicNoticeNo") int publicNoticeNo);
	int insertPublicNotice(@Param("publicNoticeTitle") String publicNoticeTitle,
							@Param("publicNoticeContent") String publicNoticeContent,
							@Param("publicNoticeDate") LocalDate publicNoticeDate);
	int updatePublicNotice(PublicNotice publicNotice);
	int deletePublicNotice(int publicNoticeNo);
}
