package com.my.attendance.dao;

import java.util.List;

import com.my.attendance.domain.Employee;
import com.my.attendance.domain.EmployeeDto;

public interface EmployeeDao {
	Employee selectEmployee(String employeeId, String employeePw);
	String selectEmployeeId(String employeeName, String employeePh);
	String selectEmployeePw(String employeeId, String employeePino);
	List<Employee> selectEmployees();
	void deleteEmployee(int employeeNo);
}
