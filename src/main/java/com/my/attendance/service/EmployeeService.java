package com.my.attendance.service;

import com.my.attendance.domain.Employee;

public interface EmployeeService {
	Employee loginCheck(String employeeId, String employeePw);
}
