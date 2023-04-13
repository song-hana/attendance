package com.my.attendance.dao.map;

import com.my.attendance.domain.Employee;

public interface EmployeeMap {
	Employee selectEmployee(String employeeId, String employeePw);
	String selectEmployeeId(String employeeName, String employeePh);
	String selectEmployeePw(String employeeId, String employeePino);
	int checkEmployeePw(int employeeNo, String employeePw);
	void updateEmployeePw(int employeeNo, String employeePw);
}
