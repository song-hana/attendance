package com.my.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.attendance.dao.CompanyDao;
import com.my.attendance.domain.Company;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired private CompanyDao companyDao;
	
	@Override
	public Company loginCheck(String companyId, String companyPw) {
		return companyDao.selectCompany(companyId, companyPw);
	}
	
	@Override
	public String findId(String companyName, String companyRegno) {
		return companyDao.selectCompanyId(companyName, companyRegno);
	}
	
	@Override
	public String findPw(String companyId, String companyEmail) {
		return companyDao.selectCompanyPw(companyId, companyEmail);
	}
}
