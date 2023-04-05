package com.my.attendance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.attendance.dao.map.CompanyMap;
import com.my.attendance.domain.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	@Autowired private CompanyMap companyMap;
	
	@Override
	public Company selectCompany(String companyId, String companyPw) {
		return companyMap.selectCompany(companyId, companyPw);
	}
	
	@Override
	public String selectCompanyId(String companyName, String companyRegno) {
		return companyMap.selectCompanyId(companyName, companyRegno);
	}
	
	@Override
	public String selectCompanyPw(String companyId, String companyEmail) {
		return companyMap.selectCompanyPw(companyId, companyEmail);
	}
}
