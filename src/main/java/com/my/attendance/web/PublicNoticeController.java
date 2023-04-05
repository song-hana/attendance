package com.my.attendance.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.attendance.domain.PublicNotice;
import com.my.attendance.service.PublicNoticeService;

@Controller
@RequestMapping("admin/notice")
public class PublicNoticeController { 
	@Autowired private PublicNoticeService publicNoticeService;
	
//	@Value("${attachPath}") private String attachPath;
	
	@GetMapping("ntclist")
	public String publicNoticeList() {
		return "admin/notice/ntclist";
	}
//	
//	@GetMapping
//	public ModelAndView main(ModelAndView mv) {
//		mv.setViewName("admin/notice/ntclist");
//		return mv;
//	}
	
//	@ResponseBody
//	@GetMapping("ntclist")
//	public String list() {
//		return "admin/notice/ntclist";
//	}
	
	@GetMapping("getntc")
	public String publicNotice(PublicNotice publicNotice, Model model, 
									@RequestParam("publicNoticeNo") int publicNoticeNo) {
		publicNotice = publicNoticeService.getPublicNoticeDetail(publicNoticeNo);
		model.addAttribute("publicNotice", publicNotice);
		return "admin/notice/getntc";
	}
	
//	@GetMapping("addntc")
//	public void addPublcNotice(String publicNoticeTitle,
//				String publicNoticeContent, @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate publicNoticeDate) {
//		publicNoticeService.addPublicNotice(publicNoticeTitle, publicNoticeContent, publicNoticeDate);
//	}
	
	@GetMapping("addntc")
	public String addPublicNotice() {
		return "admin/notice/addntc";
	}
	
	@ResponseBody
	@PostMapping("addntc")
	public ModelAndView addPublicNotice(PublicNotice publicNotice, ModelAndView mv) {
		mv.setViewName("admin/notice/ntclist");
		return mv;
	}
	
	
}
