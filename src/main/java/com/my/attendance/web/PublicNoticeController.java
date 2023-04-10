package com.my.attendance.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.attendance.domain.PublicNotice;
import com.my.attendance.service.PublicNoticeService;

@RestController("PublicNoticeController")
//@RequestMapping("admin/notice")
public class PublicNoticeController { 
	@Autowired private PublicNoticeService publicNoticeService;

//	//공지사항 목록 조회
//	@GetMapping("ntclist")
//	public ModelAndView publicNoticeList(ModelAndView mv) {
//		mv.setViewName("admin/notice/ntclist");
//		return mv;
//	}
//	
//	@ResponseBody
//	@GetMapping("list")
//	public List<PublicNotice> getPublicNoticeList() {
//		//System.out.println(publicNoticeService.getPublicNoticeLists().size());
//		return publicNoticeService.getPublicNoticeLists();
//	}
//	//목요일 확인 완료(목록 조회)

	
	//공지사항 목록
	@GetMapping
	@RequestMapping("admin/notice/ntclist")
	public ModelAndView publicNoticeList(ModelAndView mv) {
		mv.setViewName("admin/notice/ntclist");
		return mv;
	}
	
	@GetMapping("admin/notice/ntclist/get")
	@ResponseBody
	public List<PublicNotice> getPublicNoticeLists() {
		return publicNoticeService.getPublicNoticeLists();
	}
	
	//공지사항 작성
	@GetMapping
	@RequestMapping("admin/notice/addntc")
	public ModelAndView addPublicNotice(ModelAndView mv) {
		mv.setViewName("admin/notice/addntc");
		return mv;
	}
	
	@GetMapping
	@RequestMapping("admin/notice/getntc")
	public ModelAndView getPublicNotice(ModelAndView mv) {
		mv.setViewName("admin/notice/getntc");
		return mv;
	}
	
	@PostMapping("admin/notice/addntc/add")
	public ResponseEntity<String> addPublicNotice(String pubntcTitle, String pubntcContent) {
		publicNoticeService.addPublicNotice(pubntcTitle, pubntcTitle);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	//공지사항 상세 조회
	@GetMapping("ntclist/getntc")
	@ResponseBody
	public List<PublicNotice> getPublicNoticeDetail(int publicNoticeNo){
		return publicNoticeService.getPublicNoticeDetail(publicNoticeNo);
	}
	
	
	
}
