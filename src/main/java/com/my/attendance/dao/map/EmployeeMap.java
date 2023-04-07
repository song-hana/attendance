package com.my.attendance.dao.map;

import java.util.List;

import com.my.attendance.domain.Employee;

public interface EmployeeMap {
	Employee selectEmployee(String employeeId, String employeePw);
	String selectEmployeeId(String employeeName, String employeePh);
	String selectEmployeePw(String employeeId, String employeePino);
	List<Employee> selectEmployees();
	int deleteEmployee(int employeeNo);
}
