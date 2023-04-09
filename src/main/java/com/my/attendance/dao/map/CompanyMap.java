package com.my.attendance.dao.map;

import com.my.attendance.domain.Company;

public interface CompanyMap {
	Company selectCompany(String companyId, String companyPw);
	String selectCompanyId(String companyName, String companyRegno);
	String selectCompanyPw(String companyId, String companyEmail);
	int insertCompany(Company company);
	int checkCompany(String companyId);
}
