package com.my.attendance.dao;

import com.my.attendance.domain.Employee;

public interface EmployeeDao {
	Employee selectEmployee(String employeeId, String employeePw);
	String selectEmployeeId(String employeeName, String employeePh);
	String selectEmployeePw(String employeeId, String employeePino);
	int checkEmployeePw(int employeeNo, String employeePw);
	void updateEmployeePw(int employeeNo, String employeePw);
}
