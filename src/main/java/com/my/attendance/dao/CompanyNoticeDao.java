package com.my.attendance.dao;

import java.util.List;

import com.my.attendance.domain.CompanyNotice;

public interface CompanyNoticeDao {
	List<CompanyNotice> selectCompanyNoticeList();
	List<CompanyNotice> selectCompanyNotice(int companyNoticeNo);
	void insertCompanyNotice(String companyNoticeTitle, String companyNoticeContent);
	void updateCompanyNotice(CompanyNotice companyNotice);
	void deleteCompanyNotice(int companyNoticeNo);
}
