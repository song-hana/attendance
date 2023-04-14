package com.my.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.attendance.dao.AdminDao;
import com.my.attendance.dao.CompanyDao;
import com.my.attendance.dao.EmployeeDao;
import com.my.attendance.domain.Admin;
import com.my.attendance.domain.Company;
import com.my.attendance.domain.Employee;

@Service
public class UserServiceImpl implements UserService {
	@Autowired private AdminDao adminDao;
	@Autowired private CompanyDao companyDao;
	@Autowired private EmployeeDao employeeDao;
	
	// admin
	@Override
	public Admin admLoginCheck(String adminId, String adminPw) {
		return adminDao.selectAdmin(adminId, adminPw);
	}
	
	// company
	@Override
	public Company comLoginCheck(String companyId, String companyPw) {
		return companyDao.selectCompany(companyId, companyPw);
	}
	
	@Override
	public String comFindId(String companyName, int companyRegno) {
		return companyDao.selectCompanyId(companyName, companyRegno);
	}
	
	@Override
	public String comFindPw(String companyId, String companyEmail) {
		return companyDao.selectCompanyPw(companyId, companyEmail);
	}
	
	@Override
	public void addCompany(Company company) {
		 companyDao.insertCompany(company);
	}
	
	@Override
	public int checkCompany(String companyId) {
	    return companyDao.checkCompany(companyId);
	}
	
	@Override
	public void fixCompany(Company company) {
		 companyDao.updateCompany(company);
	}
	
	@Override
	public Company getCompany(String companyId) {
		return companyDao.choiceCompany(companyId);
	}
	
	// employee
	@Override
	public Employee loginCheck(String employeeId, String employeePw) {
		return employeeDao.selectEmployee(employeeId, employeePw);
	}
	
	@Override
	public String findId(String employeeName, String employeePh) {
		return employeeDao.selectEmployeeId(employeeName, employeePh);
	}
	
	@Override
	public String findPw(String employeeId, String employeePino) {
		return employeeDao.selectEmployeePw(employeeId, employeePino);
	}
	
	@Override
	public int checkEmployeePw(int employeeNo, String employeePw) {
		return employeeDao.checkEmployeePw(employeeNo, employeePw);
	}
	
	@Override
	public void fixEmployeePw(int employeeNo, String employeePw) {
		employeeDao.updateEmployeePw(employeeNo, employeePw);
	}
}
