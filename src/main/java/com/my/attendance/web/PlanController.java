package com.my.attendance.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.attendance.domain.Holiday;
import com.my.attendance.domain.Plan;
import com.my.attendance.service.PlanService;

@Controller("planController")
public class PlanController {
	@Autowired private PlanService planService;
	
	@GetMapping
	@RequestMapping("planlist")
	public ModelAndView planlist(ModelAndView mv) {
		mv.setViewName("company/plan/planlist");
		return mv;
	}
	
	@GetMapping
	@RequestMapping("getplan")
	public ModelAndView getplan(ModelAndView mv) {
		mv.setViewName("plan/getplan");
		return mv;
	}
	
	@GetMapping("planlist/getPlan")
	@ResponseBody
	public List<Plan> getPlans(String companyId) {
	    return planService.getPlans(companyId);
	}
	
	@GetMapping("planlist/getHoliday")
	@ResponseBody
	public List<Holiday> getHolidays(String companyId) {
	    return planService.getHolidays(companyId);
	}
	
	@PostMapping("planlist/add")
	public ResponseEntity<String> addPlan(String planTitle,
	    @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate planDate, String planContent) {
	    planService.addPlan(planTitle, planDate, planContent);
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("planlist/fix")
	public ResponseEntity<String> fixPlan(@RequestBody Plan plan) {
	    planService.fixPlan(plan);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("planlist/del/{planNo}")
	public ResponseEntity<String> delPlan(@PathVariable int planNo) {
	    planService.delPlan(planNo);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
}
