package com.my.attendance.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.attendance.domain.Company;
import com.my.attendance.service.CompanyService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("company/user")
public class CompanyController {
	@GetMapping("login")
	public String login() {
		return "company/user/login";
	}
	
	@GetMapping("findid")
	public String findid() {
		return "company/user/findid";
	}
	
	@GetMapping("findpw")
	public String findpw() {
		return "company/user/findpw";
	}
	
	@Autowired private CompanyService companyService;
	
	@GetMapping("loginCom")
	public String getLoginCompany(String companyId, String companyPw, 
			HttpSession session) {
		String result = "";
		Company com = companyService.loginCheck(companyId, companyPw);
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
			session.setAttribute("profileName", com.getPresident());
			result = "company/main";
		} else {
			result = "";
		}
		return result;
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/company/main";
	}
	
	@ResponseBody
	@GetMapping("findId")
	public String getcompanyId(String companyName, int companyRegno) {
		String id = companyService.findId(companyName, companyRegno);
		return id;
	}
	
	@ResponseBody
	@GetMapping("findPw")
	public String getcompanyPw(String companyId, String companyEmail) {
		String pw = companyService.findPw(companyId, companyEmail);
		return pw;
	}
}
