package com.my.attendance.service;

import java.util.List;

import com.my.attendance.domain.Admin;
import com.my.attendance.domain.Company;
import com.my.attendance.domain.Employee;

public interface UserService {
	// admin
	Admin admLoginCheck(String adminId, String adminPw);
	
	// company
	Company comLoginCheck(String companyId, String companyPw);
	String comFindId(String companyName, int companyRegno);
	String comFindPw(String companyId, String companyEmail);
	void addCompany(Company company);
	int checkCompany(String companyId);
	void fixCompany(Company company);
	List<Company> getCompany(String companyId);
	
	// employee
	Employee loginCheck(String employeeId, String employeePw);
	String findId(String employeeName, String employeePh);
	String findPw(String employeeId, String employeePino);
	void addEmployee(Employee employee);
	int checkEmployee(String empId);
	void fixEmployee(Employee employee);
	List<Employee> getEmployee(int employeeNo);
}
