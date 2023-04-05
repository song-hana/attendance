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
	@RequestMapping("holidaylist")
	public ModelAndView holidaylist(ModelAndView mv) {
		mv.setViewName("company/holiday/holidaylist");
		return mv;
	}
	
	@GetMapping
	@RequestMapping("getholiday")
	public ModelAndView getholiday(ModelAndView mv) {
		mv.setViewName("holiday/getholiday");
		return mv;
	}
	
	@GetMapping("getholiday/get")
	@ResponseBody
	public List<Holiday> getUserHoliday() {
	    return holidayService.getUserHoliday();
	}
	
	
	@GetMapping("holidaylist/get")
	@ResponseBody
	public List<Holiday> getHolidays(@RequestParam("yearMonth") @DateTimeFormat(pattern = "yyyy-MM") YearMonth yearMonth) {
	    return holidayService.getHolidays(yearMonth);
	}

	
	@PostMapping("getholiday/add")
	public ResponseEntity<String> addHoliday(@DateTimeFormat(pattern="yyyy-MM-dd") LocalDate holDate, String holContent) {
		holidayService.addHoliday(holDate, holContent);
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("holidaylist/fix")
	public ResponseEntity<String> fixHoliday(@RequestBody Holiday holiday) {
		holidayService.fixHoliday(holiday);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("holidaylist/del/{holNo}")
	public ResponseEntity<String> delHoliday(@PathVariable int holNo) {
		holidayService.delHoliday(holNo);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
}
