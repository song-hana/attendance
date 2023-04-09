package com.my.attendance.service;

import com.my.attendance.domain.Admin;

public interface AdminService {
	Admin loginCheck(String adminId, String adminPw);
}
