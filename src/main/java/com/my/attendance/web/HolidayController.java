package com.my.attendance.web;

import java.time.LocalDate;
import java.time.YearMonth;
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
import com.my.attendance.service.HolidayService;

@Controller("holidayController")
public class HolidayController {
	@Autowired private HolidayService holidayService;
	
	@GetMapping
	@RequestMapping("company/holiday/holidaylist")
	public ModelAndView holidaylist(ModelAndView mv) {
		mv.setViewName("company/holiday/holidaylist");
		return mv;
	}
	
	@GetMapping
	@RequestMapping("holiday/getholiday")
	public ModelAndView getholiday(ModelAndView mv) {
		mv.setViewName("holiday/getholiday");
		return mv;
	}
	
	@GetMapping("holiday/getholiday/get")
	@ResponseBody
	public List<Holiday> getUserHoliday(int employeeNo) {
	    return holidayService.getUserHoliday(employeeNo);
	}
	
	@GetMapping("company/holiday/holidaylist/get")
	@ResponseBody
	public List<Holiday> getHolidays(@RequestParam("yearMonth") @DateTimeFormat(pattern = "yyyy-MM") YearMonth yearMonth,
										String companyId) {
	    return holidayService.getHolidays(yearMonth, companyId);
	}
	
	@PostMapping("holiday/getholiday/add")
	public ResponseEntity<String> addHoliday(@DateTimeFormat(pattern="yyyy-MM-dd") LocalDate holDate, String holContent, int employeeNo) {
	    holidayService.addHoliday(holDate, holContent, employeeNo);
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("company/holiday/holidaylist/fix")
	public ResponseEntity<String> fixHoliday(@RequestBody Holiday holiday) {
		holidayService.fixHoliday(holiday);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("company/holiday/holidaylist/del/{holidayNo}")
	public ResponseEntity<String> delHoliday(@PathVariable int holidayNo) {
		holidayService.delHoliday(holidayNo);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
}