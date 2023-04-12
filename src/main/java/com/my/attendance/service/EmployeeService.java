package com.my.attendance.service;

import java.util.List;

import com.my.attendance.domain.Employee;

public interface EmployeeService {
	Employee loginCheck(String employeeId, String employeePw);
	String findId(String employeeName, String employeePh);
	String findPw(String employeeId, String employeePino);
	void addEmployee(Employee employee);
	int checkEmployee(String empId);
	void fixEmployee(Employee employee);
	List<Employee> getEmployee(String empId);
}
