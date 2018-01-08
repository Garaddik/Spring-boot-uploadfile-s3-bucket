package com.dot360.upload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dot360.upload.service.UploadService;

/**
 * 
 * File upload to S3 bucket
 * 
 * @author Kirankumar Garaddi
 *
 * @Created 04 January 2018 21:45:16 +0530
 *
 */
@RestController
@RequestMapping("/s3/upload")
public class UploadController {

	private UploadService uploadService;

	@Autowired
	UploadController(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
		return this.uploadService.uploadFile(file);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteFile(@RequestPart(value = "url") String fileUrl) {
		return this.uploadService.deleteFileFromS3Bucket(fileUrl);
	}
}