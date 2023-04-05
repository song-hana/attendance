package com.my.attendance.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.attendance.domain.Company;
import com.my.attendance.service.CompanyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CompanyController {
	@RequestMapping("company/user/login")
	@GetMapping
	public String login() {
		return "company/user/login";
	}
	
	@RequestMapping("company/user/findid")
	@GetMapping
	public String findid() {
		return "company/user/findid";
	}
	
	@RequestMapping("company/user/findpw")
	@GetMapping
	public String findpw() {
		return "company/user/findpw";
	}
	
	
	@Autowired private CompanyService companyService;
	
	@RequestMapping("company/user/loginCom")
	public String getLoginCompany(@RequestParam("companyId") String companyId,
			@RequestParam("companyPw") String companyPw, HttpSession session) {
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
	
	@GetMapping("company/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main";
	}
	
	@ResponseBody
	@RequestMapping("company/user/findId")
	public String getcompanyId(@RequestParam("comName") String companyName,
			@RequestParam("comReg") String companyRegno) {
		String id = companyService.findId(companyName, companyRegno);
		return id;
	}
	
	@ResponseBody
	@RequestMapping("company/user/findPw")
	public String getcompanyPw(@RequestParam("comId") String companyId,
			@RequestParam("comEmail") String companyEmail) {
		String pw = companyService.findPw(companyId, companyEmail);
		return pw;
	}
}
