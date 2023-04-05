package com.my.attendance.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping("main")
	@GetMapping
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("company/main")
	@GetMapping
	public ModelAndView comMain(ModelAndView mv) {
		mv.setViewName("company/main");
		return mv;
	}
}
