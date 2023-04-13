package com.my.attendance.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.attendance.domain.Admin;
import com.my.attendance.domain.Company;
import com.my.attendance.domain.Employee;
import com.my.attendance.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	//company--------------------------------
	@RequestMapping("admin/user/login")
	public String loginCompany() {
		return "admin/user/login";
	}
	
	@RequestMapping("admin/user/findid")
	public String findidCom() {
		return "admin/user/findid";
	}
	
	@RequestMapping("admin/user/findpw")
	public String findpwCom() {
		return "admin/user/findpw";
	}
	
	@RequestMapping("admin/user/addcom")
	public String addcom() {
		return "admin/user/addcom";
	}
	
	@RequestMapping("admin/user/fixinfo")
	public String fixCompany() {
		return "admin/user/fixinfo";
	}
	
	
	//employee ------------------------------
	@RequestMapping("user/login")
	public String loginEmployee() {
		return "user/login";
	}
	
	@RequestMapping("user/findid")
	public String findid() {
		return "user/findid";
	}
	
	@RequestMapping("user/findpw")
	public String findpw() {
		return "user/findpw";
	}
	
	@Autowired private UserService userService;
	
	//admin--------------------------------
	@ResponseBody
	@GetMapping("loginAdmin")
	public String getLoginAdmin(String adminId, String adminPw, HttpSession session) {
		String result = "";
		Admin adm = userService.admLoginCheck(adminId, adminPw);
		if(adm != null) {
			session.setAttribute("adminId", adm.getAdminId());
			session.setAttribute("adminPw", adm.getAdminPw());
			result = "admin";
		} else {
			result = "";
		}
		
		return result;
	}
	
	@GetMapping(value = {"logoutAdmin", "*/logoutAdmin"})
	public String admLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin";
	}
	
	//company--------------------------------
	@ResponseBody
	@GetMapping("admin/user/loginCom")
	public String getLoginCompany(String companyId, String companyPw, 
			HttpSession session) {
		String result = "";
		Company com = userService.comLoginCheck(companyId, companyPw);
		if(com != null) {
			session.setAttribute("comId", com.getCompanyId());
			session.setAttribute("comPw", com.getComPw());
			session.setAttribute("comName", com.getComName());
			session.setAttribute("comRegno", com.getComRegno());
			session.setAttribute("comAddr", com.getComAddr());
			session.setAttribute("comDetailAddr", com.getComDetailAddr());
			session.setAttribute("comPostcode", com.getComPostcode());
			session.setAttribute("comPh", com.getComPh());
			session.setAttribute("comEmail", com.getComEmail());
			session.setAttribute("president", com.getPresident());
			result = "company";
		} else {
			result = "";
		}
		return result;
	}
	
	@GetMapping(value = {"logoutCom", "*/logoutCom", "*/*/logoutCom"})
	public String comLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/company";
	}
	
	@ResponseBody
	@GetMapping("admin/user/findIdCom")
	public String getcompanyId(String companyName, int companyRegno) {
		String id = userService.comFindId(companyName, companyRegno);
		return id;
	}
	
	@ResponseBody
	@GetMapping("admin/user/findPwCom")
	public String getcompanyPw(String companyId, String companyEmail) {
		String pw = userService.comFindPw(companyId, companyEmail);
		return pw;
	}
	
	@PostMapping("admin/user/addcom/add")
	public ResponseEntity<String> addCompany(@RequestBody Company company) {
	    userService.addCompany(company);
	    System.out.println(company);
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("admin/user/addcom/check")
	@ResponseBody
	public int checkCompany(String companyId) {
	    return userService.checkCompany(companyId);
	}

	@PutMapping("admin/user/fixinfo/fix")
	public ResponseEntity<String> fixCompany(@RequestBody Company company){
		userService.fixCompany(company);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("admin/user/fixinfo/get")
	@ResponseBody
	public List<Company> choiceCompany(String companyId) {
	    return userService.getCompany(companyId);
	}
	
	//employee--------------------------------
	@GetMapping("user/loginEmp")
	public String getLoginEmployee(String employeeId, String employeePw, HttpSession session) {
		String result = "";
		Employee emp = userService.loginCheck(employeeId, employeePw);
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
		return "redirect:/";
	}
	
	@ResponseBody
	@GetMapping("user/findId")
	public String getEmployeeId(String employeeName, String employeePh) {
		String id = userService.findId(employeeName, employeePh);
		return id;
	}
	
	@ResponseBody
	@GetMapping("user/findPw")
	public String getEmployeePw( String employeeId, String employeePino) {
		String pw = userService.findPw(employeeId, employeePino);
		return pw;
	}
	
}
