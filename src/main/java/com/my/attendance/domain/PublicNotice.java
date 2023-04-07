package com.my.attendance.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicNotice { 
	private int publicNoticeNo;
	private String pubntcTitle; 
	private String pubntcContent; 
	private LocalDate pubntcDate; 
}