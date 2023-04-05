package com.my.attendance.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PublicNotice { 
	private int publicNoticeNo; 
	private String publicNoticeTitle; 
	private String publicNoticeContent; 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/seoul")
	private LocalDate publicNoticeDate; 
}