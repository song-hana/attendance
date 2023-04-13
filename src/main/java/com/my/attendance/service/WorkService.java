package com.my.attendance.service;

import java.time.YearMonth;
import java.util.List;

import com.my.attendance.domain.Work;
import com.my.attendance.domain.WorkDto;

public interface WorkService {
	void addStartTime(int employeeNo);
	WorkDto getAddStart(int employeeNo);
	void fixEndTime(int workNo);
	Work getAddEnd(int workNo);
	List<Work> getWorkHolidays(YearMonth yearMonth, int employeeNo);
}
