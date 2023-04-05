package com.my.attendance.dao;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.attendance.dao.map.HolidayMap;
import com.my.attendance.domain.Holiday;

@Repository("holidayDao")
public class HolidayDaoImpl implements HolidayDao {
	@Autowired private HolidayMap holidayMap;
	
	@Override
	public List<Holiday> selectHolidays(YearMonth yearMonth) {
		return holidayMap.selectHolidays(yearMonth);
	}
	
	@Override
	public List<Holiday> selectUserHoliday() {
		return holidayMap.selectUserHoliday();
	}
	
	@Override
	public void insertHoliday(LocalDate holDate, String holContent) {
		holidayMap.insertHoliday(holDate, holContent);
	}
	
	@Override
	public void updateHoliday(Holiday holiday) {
		holidayMap.updateHoliday(holiday);
	}
	
	@Override
	public void deleteHoliday(int holNo) {
		holidayMap.deleteHoliday(holNo);
	}
}
