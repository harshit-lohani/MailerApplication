package com.harshit.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class IOServices {
	public static boolean uploadFile(MultipartFile file) {

		System.out.println(file.getContentType());

		if (!file.isEmpty()) {
			BufferedOutputStream bos = null;
			try {
				byte[] fileBytes = file.getBytes();
				// location to save the file

//				String path = System.getProperty("java.io.tmpdir");
				String newPath = "E:\\JavaProjects\\EmailSpringDB\\src\\main\\temp\\";

				String fileName = newPath + file.getOriginalFilename();

				System.out.println("Controller file name is" + fileName);

				bos = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
				bos.write(fileBytes);
				return true;
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			} finally {
				
				if (bos != null) {
					try {
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
		} else {
			return false;
		}
		return false;
	}

}
