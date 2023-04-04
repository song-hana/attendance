package com.my.attendance.dao;

import com.my.attendance.domain.Employee;

public interface EmployeeDao {
	Employee selectEmployee(String employeeId, String employeePw);
}
