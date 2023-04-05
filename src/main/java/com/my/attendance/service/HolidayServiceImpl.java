package com.my.attendance.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.attendance.dao.HolidayDao;
import com.my.attendance.domain.Holiday;

@Service
public class HolidayServiceImpl implements HolidayService {
	@Autowired private HolidayDao holidayDao;
	
	@Override
	public List<Holiday> getHolidays(YearMonth yearMonth) {
		return holidayDao.selectHolidays(yearMonth);
	}
	
	@Override
	public List<Holiday> getUserHoliday() {
		return holidayDao.selectUserHoliday();
	}
	
	@Override
	public void addHoliday(LocalDate holDate, String holContent) {
		holidayDao.insertHoliday(holDate, holContent);
	}
	
	@Override
	public void fixHoliday(Holiday holiday) {
		holidayDao.updateHoliday(holiday);
	}
	
	@Override
	public void delHoliday(int holNo) {
		holidayDao.deleteHoliday(holNo);
	}
}
