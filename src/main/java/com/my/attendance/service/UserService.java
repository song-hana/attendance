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
	void delCompany(String companyId);
	List<Company> getCompany(String companyId);
	List<Company> getCompanys();
	
	// employee
	Employee loginCheck(String employeeId, String employeePw);
	String findId(String employeeName, String employeePh);
	String findPw(String employeeId, String employeePino);
	List<Employee> getEmployees(String companyId);
	List<Employee> getEmployeeInfo(int employeeNo);
	void delEmployee(int employeeNo);
}
