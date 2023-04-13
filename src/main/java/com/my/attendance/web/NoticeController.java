package com.my.attendance.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.my.attendance.service.NoticeService;

@RestController("NoticeController")
public class NoticeController {
	@Autowired private NoticeService noticeService;
	
	//admin 전체 공지사항 목록
	@GetMapping
	@RequestMapping("admin/notice/admntclist")
	public ModelAndView getadmntclist(ModelAndView mv) {
		mv.setViewName("admin/notice/admntclist");
		return mv;
	}
	
	@GetMapping("admin/notice/ntclist/get")
	@ResponseBody
	public List<PublicNotice> getPublicNoticeLists() {
		return noticeService.getPublicNoticeLists();
	}
	
	//admin 전체 공지사항 추가
	@GetMapping
	@RequestMapping("admin/notice/addntc")
	public ModelAndView addPublicNotice(ModelAndView mv) {
		mv.setViewName("admin/notice/addntc");
		return mv;
	}
	
	@PostMapping("admin/notice/addntc/add")
	public void addPublicNotice(String publicNoticeTitle, String publicNoticeContent) {
		noticeService.addPublicNotice(publicNoticeTitle, publicNoticeContent);
	}
	
	//admin 전체 공지사항 상세 조회
	@GetMapping
	@RequestMapping("admin/notice/admgetntc")
	public ModelAndView getadmgetntc(ModelAndView mv) {
		mv.setViewName("admin/notice/admgetntc");
		return mv;
	}
	
	@GetMapping("admin/notice/getntc/get")
	@ResponseBody
	public List<PublicNotice> getPublicNotice(int publicNoticeNo) {
		return noticeService.getPublicNotice(publicNoticeNo);
	}
	
	//admin 전체 공지사항 수정
	@GetMapping
	@RequestMapping("admin/notice/fixntc")
	public ModelAndView fixPublicNotice(ModelAndView mv) {
		mv.setViewName("admin/notice/fixntc");
		return mv;
	}
	
	@PutMapping("admin/notice/fixntc/fix")
	@ResponseBody
	public void fixPublicNotice(@RequestBody PublicNotice publicNotice) {
		noticeService.fixPublicNotice(publicNotice);
	}
	
	//admin 전체 공지사항 삭제
	@DeleteMapping("admin/notice/getntc/del/{publicNoticeNo}")
	public void delPublicNotice(@PathVariable int publicNoticeNo) {
		noticeService.delPublicNotice(publicNoticeNo);
	}
	
	//company 전체 공지사항 목록
	@GetMapping
	@RequestMapping("admin/notice/ntclist")
	public ModelAndView getntclist(ModelAndView mv) {
		mv.setViewName("admin/notice/ntclist");
		return mv;
	}

	//company 전체 공지사항 상세 조회
	@GetMapping
	@RequestMapping("admin/notice/getntc")
	public ModelAndView getntc(ModelAndView mv) {
		mv.setViewName("admin/notice/getntc");
		return mv;
	}
	
	//user 전체 공지사항 목록
	@GetMapping
	@RequestMapping("notice/ntclist")
	public ModelAndView usergetntclist(ModelAndView mv) {
		mv.setViewName("notice/ntclist");
		return mv;
	}
	
	//user 전체 공지사항 상세 조회
	@GetMapping
	@RequestMapping("notice/getntc")
	public ModelAndView usergetntc(ModelAndView mv) {
		mv.setViewName("notice/getntc");
		return mv;
	}
	
}
