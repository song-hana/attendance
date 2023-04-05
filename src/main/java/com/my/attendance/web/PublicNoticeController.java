package com.my.attendance.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.attendance.domain.PublicNotice;
import com.my.attendance.service.PublicNoticeService;

@Controller
@RequestMapping("admin/notice")
public class PublicNoticeController {
	@Autowired private PublicNoticeService publicNoticeService;
	
	//전체 공지 리스트 조회
	@GetMapping("ntclist")
	public String publicNoticeList() {
		return "admin/notice/ntclist";
	}

	//전체 공지 상세 조회
	@GetMapping("getntc")
	public String detailPublicNotice(PublicNotice publicNotice, Model model, 
									@RequestParam("publicNoticeNo") int publicNoticeNum) {
		publicNotice = publicNoticeService.getDetailPublicNotice(publicNoticeNum);
		model.addAttribute("publicNotice", publicNotice);
		return "admin/notice/getntc";
	}
	
	//전체 공지 작성
	@GetMapping("addntc")
	public String addPublicNotice() {
		return "admin/notice/addntc";
	}
}
