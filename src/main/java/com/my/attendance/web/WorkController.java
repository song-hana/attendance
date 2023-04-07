package com.my.attendance.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.attendance.domain.Work;
import com.my.attendance.domain.WorkDto;
import com.my.attendance.service.WorkService;

import jakarta.servlet.http.HttpSession;

@Controller
public class WorkController {
	@Autowired WorkService workService;
	
	@RequestMapping("work/record")
	@GetMapping
	public String recordTime() {
		return "work/record";
	}
	
	@ResponseBody
	@RequestMapping("work/start")
	public String recordStartTime(@RequestParam("empNo") int employeeNo,
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
	@RequestMapping("work/end")
	public String recordEndTime(@RequestParam("workNo") int workNo,
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
}
