package com.my.attendance.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.attendance.domain.PublicNotice;
import com.my.attendance.service.PublicNoticeService;

@RestController("PublicNoticeController")
public class PublicNoticeController { 
	@Autowired private PublicNoticeService publicNoticeService;

	//공지사항 목록
	@GetMapping()
	@RequestMapping("admin/notice/ntclist")
	public ModelAndView publicNoticeList(ModelAndView mv) {
		mv.setViewName("admin/notice/ntclist");
		return mv;
	}
	
	@GetMapping("admin/notice/ntclist/get")
	@ResponseBody
	public List<PublicNotice> getPublicNoticeLists() {
		//System.out.println(publicNoticeService.getPublicNoticeLists().size());
		return publicNoticeService.getPublicNoticeLists();
	}
	
	//공지사항 작성
	@GetMapping
	@RequestMapping("admin/notice/addntc")
	public ModelAndView addPublicNotice(ModelAndView mv) {
		mv.setViewName("admin/notice/addntc");
		return mv;
	}
	
	@PostMapping("admin/notice/addntc/add")
	public ResponseEntity<String> addPublicNotice(String pubntcTitle, String pubntcContent) {
		publicNoticeService.addPublicNotice(pubntcTitle, pubntcContent);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	//공지사항 상세 조회
	@GetMapping
	@RequestMapping("admin/notice/getntc")
	public ModelAndView getPublicNotice(ModelAndView mv) {
		mv.setViewName("admin/notice/getntc");
		return mv;
	}
	
	@GetMapping("admin/notice/ntclist/getNtc")
	@ResponseBody
	public List<PublicNotice> getPublicNoticeDetail(int publicNoticeNo){
		return publicNoticeService.getPublicNoticeDetail(publicNoticeNo);
	}
	
	//공지사항 수정
	@GetMapping
	@RequestMapping("admin/notice/fixntc")
	public ModelAndView fixPublicNotice(ModelAndView mv) {
		mv.setViewName("admin/notice/fixntc");
		return mv;
	}
	
	@PutMapping("admin/notice/ntclist/fixNtc")
	@ResponseBody
	public void fixPublicNotice(@RequestBody PublicNotice publicNotice) {
		publicNoticeService.fixPublicNotice(publicNotice);
	}


	
	//공지사항 삭제
	@DeleteMapping("admin/notice/getntc/del/{publicNoticeNo}")
	public void delPublicNotice(@PathVariable int publicNoticeNo) {
		publicNoticeService.delPublicNotice(publicNoticeNo);
	}

}
