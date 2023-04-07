package com.my.attendance.dao.map;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.my.attendance.domain.PublicNotice;

public interface PublicNoticeMap {	 
	List<PublicNotice> selectPublicNoticeLists();
	PublicNotice selectPublicNoticeDetail(@Param("publicNoticeNo") int publicNoticeNo);
	int insertPublicNotice(@Param("pubntcTitle") String pubntcTitle,
							@Param("pubntcContent") String pubntcContent,
							@Param("pubntcDate") LocalDate pubntcDate);
	int updatePublicNotice(PublicNotice publicNotice);
	int deletePublicNotice(int publicNoticeNo);
}
