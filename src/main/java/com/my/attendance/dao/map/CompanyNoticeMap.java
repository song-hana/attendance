package com.my.attendance.dao.map;

import java.util.List;

import com.my.attendance.domain.CompanyNotice;

public interface CompanyNoticeMap {
	List<CompanyNotice> selectCompanyNoticeList();
	List<CompanyNotice> selectCompanyNotice(int companyNoticeNo);
	int insertCompanyNotice(String companyNoticeTitle, String companyNoticeContent);
	int updateCompanyNotice(CompanyNotice companyNotice);
	int deleteCompanyNotice(int companyNoticeNo);
}
