package com.my.attendance.service;

import java.util.List;

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
	
	@Override
	public String findId(String employeeName, String employeePh) {
		return employeeDao.selectEmployeeId(employeeName, employeePh);
	}
	
	@Override
	public String findPw(String employeeId, String employeePino) {
		return employeeDao.selectEmployeePw(employeeId, employeePino);
	}
	
	@Override
	public List<Employee> getEmployees() {
		return employeeDao. selectEmployees();
	}
	
	@Override
	public void delEmployee(int employeeNo) {
		employeeDao.deleteEmployee(employeeNo);
	}
}
