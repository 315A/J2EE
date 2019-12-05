package com.springboot.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.coyote.http11.InputFilter;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.domain.Image;
import com.springboot.mapper.ImageMapper;
import com.springboot.utils.ImageUtil;


@RestController
@RequestMapping("/image")
public class ImageController {
	@Autowired
	ImageMapper imageMapper;
	
	@RequestMapping("/upload")
	@ResponseBody
	String uploadImage(@RequestParam("img") MultipartFile imgFile,
			@RequestParam(value="username",required = true)String username,
			@RequestParam(value="longtitude",required = false)Double longtitude,
			@RequestParam(value="latitude",required = false)Double latitude,
			HttpServletRequest request) throws Exception{
		System.out.print("image");
		byte[] img = imgFile.getBytes();
		byte[] thumbImg= ImageUtil.generateThumb(img);
		Date date = new Date();
        Image image=new Image();
        image.setDate(date);
        image.setImg(img);
        image.setThumbImg(thumbImg);
        image.setUsername(username);
        image.setLongtitude(longtitude);
        image.setLatitude(latitude);
        imageMapper.InsertImage(image);
		return "图片插入成功";
	}
	@RequestMapping("/download/{id}")
	@ResponseBody
	Image downloadImage(@PathVariable("id") Long id,
			HttpServletRequest request) {
				return imageMapper.getImageById(id);
	}
	

}
