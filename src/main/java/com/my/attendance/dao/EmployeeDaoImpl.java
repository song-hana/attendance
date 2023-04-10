package com.my.attendance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.attendance.dao.map.EmployeeMap;
import com.my.attendance.domain.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired private EmployeeMap employeeMap;
	
	@Override
	public Employee selectEmployee(String employeeId, String employeePw) {
		return employeeMap.selectEmployee(employeeId, employeePw);
	}
	
	@Override
	public String selectEmployeeId(String employeeName, String employeePh) {
		return employeeMap.selectEmployeeId(employeeName, employeePh);
	}
	
	@Override
	public String selectEmployeePw(String employeeId, String employeePino) {
		return employeeMap.selectEmployeePw(employeeId, employeePino);
	}

}
