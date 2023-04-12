package com.my.attendance.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.attendance.domain.Work;
import com.my.attendance.domain.WorkDto;
import com.my.attendance.service.WorkService;

import jakarta.servlet.http.HttpSession;

@Controller
public class WorkController {
	@Autowired WorkService workService;
	
	@GetMapping("work/record")
	public String recordTime() {
		return "work/record";
	}
	
	@GetMapping
	@RequestMapping("admin/work/getlist")
	public ModelAndView getlist(ModelAndView mv) {
		mv.setViewName("admin/work/getlist");
		return mv;
	}
	
	@ResponseBody
	@GetMapping("work/record/start")
	public String recordStartTime(int employeeNo,
			HttpSession session) {
		String result = "";
		
		workService.addStartTime(employeeNo); 
		WorkDto work = workService.getAddStart(employeeNo);
		
		if(work != null) {
			session.setAttribute("workNo", work.getWorkNo());
			result = work.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		}
		
		return result;
	}
	
	@ResponseBody
	@GetMapping("work/record/end")
	public String recordEndTime(int workNo,
			HttpSession session) {
		String result = "";
		
		workService.fixEndTime(workNo);
		Work work = workService.getAddEnd(workNo);
		LocalDateTime time = work.getEndTime();
		
		if(time != null) {
			result = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		}
		
		session.setAttribute("workNo", null);
		
		return result;
	}
	
	@GetMapping("admin/work/getlist/get")
	@ResponseBody
	public List<Work> getChoiceDay(@RequestParam("choiceDay") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate choiceDay, String companyId) {
	    return workService.getChoiceDay(choiceDay, companyId);
	}
	
	@GetMapping("admin/work/getlist/getworkHoliday")
	@ResponseBody
	public List<Work> getworkHoliday(@RequestParam("choiceDay") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate choiceDay, String companyId) {
		return workService.getworkHoliday(choiceDay, companyId);
	}
}
