package com.my.attendance.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PublicNotice { 
	private int publicNoticeNo;
	private String pubntcTitle; 
	private String pubntcContent;
	private LocalDate pubntcDate; 
}