package com.my.attendance.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.attendance.domain.Ask;
import com.my.attendance.domain.Plan;
import com.my.attendance.service.AskService;

@Controller("askController")
public class AskController {
	@Autowired private AskService askService;
	
	@GetMapping
	@RequestMapping("asklist")
	public ModelAndView asklist(ModelAndView mv) {
		mv.setViewName("company/ask/asklist");
		return mv;
	}
	
	@GetMapping
	@RequestMapping("addask")
	public ModelAndView addask(ModelAndView mv) {
		mv.setViewName("company/ask/addask");
		return mv;
	}
	
	@GetMapping
	@RequestMapping("getask")
	public ModelAndView getask(ModelAndView mv) {
		mv.setViewName("company/ask/getask");
		return mv;
	}
	
	@GetMapping
	@RequestMapping("admasklist")
	public ModelAndView admasklist(ModelAndView mv) {
		mv.setViewName("admin/ask/asklist");
		return mv;
	}
	
	@GetMapping
	@RequestMapping("admgetask")
	public ModelAndView admgetask(ModelAndView mv) {
		mv.setViewName("admin/ask/getask");
		return mv;
	}
	
	@GetMapping
	@RequestMapping("userasklist")
	public ModelAndView userasklist(ModelAndView mv) {
		mv.setViewName("ask/asklist");
		return mv;
	}
	
	@GetMapping
	@RequestMapping("useraddask")
	public ModelAndView useraddask(ModelAndView mv) {
		mv.setViewName("ask/addask");
		return mv;
	}
	
	@GetMapping
	@RequestMapping("usergetask")
	public ModelAndView usergetask(ModelAndView mv) {
		mv.setViewName("ask/getask");
		return mv;
	}

	@GetMapping("asklist/get")
	@ResponseBody
	public List<Ask> getAsks() {
	    return askService.getAsks();
	}

	@GetMapping("asklist/getAsk")
	@ResponseBody
	public List<Ask> getAsk(int askNo) {
		return askService.getAsk(askNo);
	}
	
	@PostMapping("addask/add")
	public ResponseEntity<String> addAsk(String askTitle, String askName, String askContent) {
	    askService.addAsk(askTitle, askName, askContent);
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("admgetask/add")
	public ResponseEntity<String> addAnswer(@RequestBody Ask ask) {
	    askService.addAnswer(ask);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("admgetask/del/{askNo}")
	public ResponseEntity<String> delPlan(@PathVariable int askNo) {
	    askService.delAsk(askNo);
	    return new ResponseEntity<>(HttpStatus.OK);
	}

}
