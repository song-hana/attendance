package com.my.attendance.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.attendance.domain.Admin;
import com.my.attendance.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {
	@GetMapping("login")
	public String login() {
		return "admin/login";
	}
	
	@Autowired private AdminService adminService;
	
	@ResponseBody
	@GetMapping(value = {"loginAdmin", "*/loginAdmin"})
	public String getLoginAdmin(String adminId, String adminPw, HttpSession session) {
		String result = "";
		Admin adm = adminService.loginCheck(adminId, adminPw);
		if(adm != null) {
			session.setAttribute("adminId", adm.getAdminId());
			session.setAttribute("adminPw", adm.getAdminPw());
			result = "admin";
		} else {
			result = "";
		}
		
		return result;
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
