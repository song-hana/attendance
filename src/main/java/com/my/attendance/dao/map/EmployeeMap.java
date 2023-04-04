package com.my.attendance.dao.map;

import com.my.attendance.domain.Employee;

public interface EmployeeMap {
	Employee selectEmployee(String employeeId, String employeePw);
}
