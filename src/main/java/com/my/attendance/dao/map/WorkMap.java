package com.my.attendance.dao.map;

import com.my.attendance.domain.Work;
import com.my.attendance.domain.WorkDto;

public interface WorkMap {
	int insertStartTime(int employeeNo);
	WorkDto selectInsertStart(int employeeNo);
	int updateEndTime(int workNo);
	Work selectInsertEnd(int workNo);
}
