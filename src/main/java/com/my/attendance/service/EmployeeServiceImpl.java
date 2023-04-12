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
	public void addEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}
	
	@Override
	public int checkEmployee(String empId) {
		return employeeDao.checkEmployee(empId);
	}
	
	@Override
	public void fixEmployee(Employee employee) {
		 employeeDao.updateEmployee(employee);
	}
	
	@Override
	public List<Employee> getEmployee(String empId){
		return employeeDao.choiceEmployee(empId);
	}
}
