package com.my.attendance.dao;

import java.time.YearMonth;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.my.attendance.domain.Work;
import com.my.attendance.domain.WorkDto;

public interface WorkDao {
	void inseartStartTime(int employeeNo);
	WorkDto selectInsertStart(int employeeNo);
	void updateEndTime(int workNo);
	Work selectInsertEnd(int workNo);
	List<Work> selectWorkHolidays(YearMonth yearMonth, int employeeNo);
}	
