package com.my.attendance.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.attendance.domain.PublicNotice;
import com.my.attendance.service.PublicNoticeService;

@RestController("PublicNoticeController")
@RequestMapping("admin/notice")
public class PublicNoticeController { 
	@Autowired private PublicNoticeService publicNoticeService;

	//공지사항 목록 조회
	@GetMapping("ntclist")
	public ModelAndView publicNoticeList(ModelAndView mv) {
		mv.setViewName("admin/notice/ntclist");
		return mv;
	}
	
	@ResponseBody
	@GetMapping("list")
	public List<PublicNotice> getPublicNoticeList() {
		/*System.out.println(publicNoticeService.getPublicNoticeLists().size());*/
		return publicNoticeService.getPublicNoticeLists();
	}
	//목요일 확인 완료(목록 조회)
	
	
	
	//공지사항 추가, 데이터 읽기
	@GetMapping("addntc")
	public ModelAndView addPublicNotice(ModelAndView mv) {
		mv.setViewName("admin/notice/addntc");
		return mv;
	}
	
	//공지사항 추가, 데이터 추가하기
	@ResponseBody
	@PostMapping("addPublicNotice")
	public void addPublicNotice(String pubntcTitle, String pubntcContent) {
		publicNoticeService.addPublicNotice(pubntcTitle, pubntcContent);
	}
	

}