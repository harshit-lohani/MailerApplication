package com.harshit.service;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class IOServices {

	private static String storagePath = "E:\\JavaProjects\\EmailSpringDB\\src\\main\\temp\\";
	private static String profilePath = "E:\\JavaProjects\\EmailSpringDB\\src\\main\\webapp\\images\\profile\\";
//	private static String profilePath2 = "E:\\JavaProjects\\EmailSpringDB\\src\\main\\temp\\profile\\";
	

	public static String uploadFile(MultipartFile file) {
		
		System.out.println(file.getContentType());

		if (file.isEmpty()) {
			return "EMPTY_FILE";
		}

		try {
			String fileName = storagePath + file.getOriginalFilename();
			file.transferTo(new File(fileName));
			return "SUCCESS";
		} catch (IOException e) {
			e.printStackTrace();
			return "IO_EXCEPTION";
		}
	}

	public static boolean multiUploadFile(MultipartFile[] files) {

		if (null != files && files.length > 0) {
			for (MultipartFile file : files) {
				
				if(file.isEmpty()) {
					continue;
				}
				
				String fileName = storagePath + file.getOriginalFilename();
				try {
					file.transferTo(new File(fileName));
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
			return true;
		}
		else {
			System.out.println("No Files found on path!");
			return true;
		}
	}
	
	
	public static boolean uploadProfile(MultipartFile file) {
		
		if (file.isEmpty()) {
			return false;
		}

		try {
			String fileName = profilePath + file.getOriginalFilename();
			file.transferTo(new File(fileName));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
