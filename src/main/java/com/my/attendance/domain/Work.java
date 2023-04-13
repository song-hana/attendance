package com.my.attendance.domain;

import java.time.LocalDateTime;
import java.time.YearMonth;

import lombok.Data;

@Data
public class Work {
	private int workNo;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int employeeNo;
	private YearMonth yearMonth;
}
