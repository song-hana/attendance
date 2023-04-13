package com.my.attendance.dao.map;

import java.time.YearMonth;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.my.attendance.domain.Work;
import com.my.attendance.domain.WorkDto;

public interface WorkMap {
	int insertStartTime(int employeeNo);
	WorkDto selectInsertStart(int employeeNo);
	int updateEndTime(int workNo);
	Work selectInsertEnd(int workNo);
	List<Work> selectWorkHolidays(@Param("yearMonth")YearMonth yearMonth,
			@Param("employeeNo") int employeeNo);
}
