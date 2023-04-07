package com.my.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.attendance.dao.AdminDao;
import com.my.attendance.domain.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired private AdminDao adminDao;
	
	@Override
	public Admin loginCheck(String adminId, String adminPw) {
		return adminDao.selectAdmin(adminId, adminPw);
	}
}
