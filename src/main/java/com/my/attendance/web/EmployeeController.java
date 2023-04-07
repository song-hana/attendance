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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.attendance.domain.Employee;
import com.my.attendance.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	@RequestMapping("user/login")
	@GetMapping
	public String login() {
		return "user/login";
	}
	
	@RequestMapping("user/findid")
	@GetMapping
	public String findid() {
		return "user/findid";
	}
	
	@RequestMapping("user/findpw")
	@GetMapping
	public String findpw() {
		return "user/findpw";
	}
	
	
	@Autowired private EmployeeService employeeService;
	
	@RequestMapping("user/loginEmp")
	public String getLoginEmployee(@RequestParam("employeeId") String employeeId,
			@RequestParam("employeePw") String employeePw, HttpSession session) {
		String result = "";
		Employee emp = employeeService.loginCheck(employeeId, employeePw);
		if(emp != null) {
			session.setAttribute("empNo", emp.getEmployeeNo());
			session.setAttribute("empId", emp.getEmpId());
			session.setAttribute("empPw", emp.getEmpPw());
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
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main";
	}
	
	@ResponseBody
	@RequestMapping("user/findId")
	public String getEmployeeId(@RequestParam("empName") String employeeName,
			@RequestParam("empPh") String employeePh) {
		String id = employeeService.findId(employeeName, employeePh);
		return id;
	}
	
	@ResponseBody
	@RequestMapping("user/findPw")
	public String getEmployeePw(@RequestParam("empId") String employeeId,
			@RequestParam("empPino") String employeePino) {
		String pw = employeeService.findPw(employeeId, employeePino);
		return pw;
	}
	
	@GetMapping
	@RequestMapping("emplist")
	public ModelAndView listEmployee(ModelAndView mv) {
		mv.setViewName("company/emp/emplist");
		return mv;
	}
	
	@ResponseBody
	@GetMapping("emplist/get")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@DeleteMapping("emplist/del/{employeeNo}")
	public ResponseEntity<String> delEmployee(@PathVariable int employeeNo) {
	    employeeService.delEmployee(employeeNo);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
}
