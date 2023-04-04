package com.my.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.attendance.dao.EmployeeDao;
import com.my.attendance.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired private EmployeeDao employeeDao;
	
	@Override
	public Employee loginCheck(String employeeId, String employeePw) {
		return employeeDao.selectEmployee(employeeId, employeePw);
	}
}
