package com.my.attendance.dao.map;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.my.attendance.domain.Holiday;
import com.my.attendance.domain.Plan;

public interface PlanMap {
	List<Plan> selectPlans();
	List<Holiday> selectHolidays();
	int insertPlan(@Param("planTitle") String planTitle,
					@Param("planDate") LocalDate planDate,
					@Param("planContent") String planContent);
	int updatePlan(Plan plan);
	int deletePlan(int planNo);
}
