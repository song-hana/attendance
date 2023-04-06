package com.my.attendance.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import com.my.attendance.domain.Holiday;

public interface HolidayService {
	List<Holiday> getHolidays(YearMonth yearMonth);
	List<Holiday> getUserHoliday(int empNo);
	void addHoliday(LocalDate holDate, String holContent, int empNo);
	void fixHoliday(Holiday holiday);
	void delHoliday(int holNo);
}
