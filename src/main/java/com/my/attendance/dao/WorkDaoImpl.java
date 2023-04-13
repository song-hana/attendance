package com.my.attendance.dao;

import java.time.YearMonth;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.attendance.dao.map.WorkMap;
import com.my.attendance.domain.Work;
import com.my.attendance.domain.WorkDto;

@Repository
public class WorkDaoImpl implements WorkDao {
	@Autowired WorkMap workMap;
	
	@Override
	public void inseartStartTime(int employeeNo) {
		workMap.insertStartTime(employeeNo);
	}
	
	@Override
	public WorkDto selectInsertStart(int employeeNo) {
		return workMap.selectInsertStart(employeeNo);
	}
	
	@Override
	public void updateEndTime(int workNo) {
		workMap.updateEndTime(workNo);
	}
	
	@Override
	public Work selectInsertEnd(int workNo) {
		return workMap.selectInsertEnd(workNo);
	}
	
	@Override
	public List<Work> selectWorkHolidays(@Param("yearMonth")YearMonth yearMonth,
										@Param("employeeNo") int employeeNo) {
		return workMap.selectWorkHolidays(yearMonth, employeeNo);
	}
}
