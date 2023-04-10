package com.my.attendance.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.attendance.domain.Employee;
import com.my.attendance.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	@GetMapping("user/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("user/findid")
	public String findid() {
		return "user/findid";
	}
	
	@GetMapping("user/findpw")
	public String findpw() {
		return "user/findpw";
	}
	
	@Autowired private EmployeeService employeeService;
	
	@GetMapping("user/loginEmp")
	public String getLoginEmployee(String employeeId, String employeePw, HttpSession session) {
		String result = "";
		Employee emp = employeeService.loginCheck(employeeId, employeePw);
		if(emp != null) {
			session.setAttribute("empNo", emp.getEmployeeNo());
			session.setAttribute("empId", emp.getEmpId());
			session.setAttribute("empPw", emp.getEmpPw());
			session.setAttribute("empName", emp.getEmpName());
			session.setAttribute("empAddr", emp.getEmpAddr());
			session.setAttribute("empDetailAddr", emp.getEmpDetailAddr());
			session.setAttribute("empPostcode", emp.getEmpPostcode());
			session.setAttribute("empPh", emp.getEmpPh());
			session.setAttribute("empEmail", emp.getEmpEmail());
			session.setAttribute("hireDate", emp.getHireDate());
			session.setAttribute("empPosition", emp.getEmpPosition());
			session.setAttribute("empPino", emp.getEmpPino());
			session.setAttribute("profileName", emp.getProfileName());
			session.setAttribute("comId", emp.getCompanyId());
			result = "main";
		} else {
			result = "";
		}
		return result;
	}
	
	@GetMapping(value = {"logout", "*/logout"})
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
	@ResponseBody
	@GetMapping("user/findId")
	public String getEmployeeId(String employeeName, String employeePh) {
		String id = employeeService.findId(employeeName, employeePh);
		return id;
	}
	
	@ResponseBody
	@GetMapping("user/findPw")
	public String getEmployeePw( String employeeId, String employeePino) {
		String pw = employeeService.findPw(employeeId, employeePino);
		return pw;
	}
	
	@GetMapping
	@RequestMapping("company/emp/emplist")
	public ModelAndView listEmployee(ModelAndView mv) {
		mv.setViewName("company/emp/emplist");
		return mv;
	}
	
}
