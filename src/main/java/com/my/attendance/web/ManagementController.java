package com.my.attendance.web;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ManagementController {
	@RequestMapping("admin/management/logo")
	@AdminCheck
	public String logoAdmin() {
		return "admin/management/logo";
	}
	   
	@PostMapping("admin/management/logo")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		String uploadFolder = "C:/dev/attach/";

		try {
			file.transferTo(new File(uploadFolder + "logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "admin/management/logo";
	}

	@PostMapping("admin/management/logo_m")
	public String handleFileUpload2(@RequestParam("file") MultipartFile file) {
		String uploadFolder = "C:/dev/attach/";

		try {
			file.transferTo(new File(uploadFolder + "logo_m.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "admin/management/logo";
	}

	@PostMapping("admin/management/intro")
	public String handleFileUpload3(@RequestParam("file") MultipartFile file) {
		String uploadFolder = "C:/dev/attach/";

		try {
			file.transferTo(new File(uploadFolder + "intro_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "admin/management/logo";
	}

	@PostMapping("admin/management/intro_m")
	public String handleFileUpload4(@RequestParam("file") MultipartFile file) {
		String uploadFolder = "C:/dev/attach/";

		try {
			file.transferTo(new File(uploadFolder + "intro_img_m.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "admin/management/logo";
	}

	@PostMapping("admin/management/emp_img")
	public String handleFileUpload5(@RequestParam("file") MultipartFile file) {
		String uploadFolder = "C:/dev/attach/";

		try {
			file.transferTo(new File(uploadFolder + "emp_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "admin/management/logo";
	}
}