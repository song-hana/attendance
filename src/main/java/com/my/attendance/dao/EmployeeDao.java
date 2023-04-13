package com.my.attendance.dao;

import java.util.List;
import com.my.attendance.domain.Employee;

public interface EmployeeDao {
	Employee selectEmployee(String employeeId, String employeePw);
	String selectEmployeeId(String employeeName, String employeePh);
	String selectEmployeePw(String employeeId, String employeePino);
	List<Employee> selectEmployees(String companyId);
	List<Employee> selectEmployeeInfo(int employeeNo);
	void deleteEmployee(int employeeNo);
}
