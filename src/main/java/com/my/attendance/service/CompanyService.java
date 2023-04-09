package com.my.attendance.service;

import com.my.attendance.domain.Company;

public interface CompanyService {
	Company loginCheck(String companyId, String companyPw);
	String findId(String companyName, String companyRegno);
	String findPw(String companyId, String companyEmail);
	void addCompany(Company company);
	int checkCompany(String companyId);
}
