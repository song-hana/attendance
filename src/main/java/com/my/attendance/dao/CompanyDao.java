package com.my.attendance.dao;

import com.my.attendance.domain.Company;

public interface CompanyDao {
	Company selectCompany(String companyId, String companyPw);
	String selectCompanyId(String companyName, int companyRegno);
	String selectCompanyPw(String companyId, String companyEmail);
	int insertCompany(Company company);
	int checkCompany(String companyId);
	void updateCompany(Company company);
	Company choiceCompany(String companyId);
}
