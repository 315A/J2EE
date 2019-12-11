package com.springboot.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.catalina.User;
import org.apache.coyote.http11.InputFilter;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.domain.Image;
import com.springboot.domain.ImageLog;
import com.springboot.mapper.ImageLogMapper;
import com.springboot.mapper.ImageMapper;
import com.springboot.utils.ImageUtil;


@RestController
@RequestMapping("/image")
public class ImageController {
	@Autowired
	ImageMapper imageMapper;
	@Autowired
	ImageLogMapper imageLogMapper;
	
	@RequestMapping("/upload")
	@ResponseBody
	String uploadImage(@RequestParam("img") MultipartFile imgFile,
			@RequestParam(value="username",required = true)String username,
			@RequestParam(value="location",required = false)String location,
			@RequestParam(value="longtitude",required = false)Double longtitude,
			@RequestParam(value="latitude",required = false)Double latitude,
			HttpServletRequest request) throws Exception{
		byte[] img = imgFile.getBytes();
		byte[] thumbImg= ImageUtil.generateThumb(img);
		Date date = new Date();
        Image image=new Image();
        image.setDate(date);image.setImg(img);
        image.setThumbImg(thumbImg);image.setUsername(username);image.setLocation(location);
        image.setLongtitude(longtitude);image.setLatitude(latitude);
        imageMapper.InsertImage(image);
        
		ImageLog imageLog=new ImageLog();
		imageLog.setDate(new Date());
		imageLog.setOp("INSERT");
		imageLog.setUsername(username);
		imageLogMapper.InsertImageLog(imageLog);
		return "图片插入成功";
	}
	@RequestMapping("/download/{id}")
	@ResponseBody
	Image downloadImage(@PathVariable("id") Long id,
			@RequestParam(value="username",required = true)String username,
			HttpServletRequest request) {
		ImageLog imageLog=new ImageLog();
		imageLog.setDate(new Date());
		imageLog.setOp("RETRIEVE");
		imageLog.setUsername(username);
		imageLogMapper.InsertImageLog(imageLog);
		return imageMapper.getImageById(id);
	}
	@RequestMapping("/search")
	@ResponseBody
	List<Image> searchImage(@RequestParam(value="username",required = true)String username,
			@RequestParam(value="location",required = true)String location,
			@RequestParam(value="lowLong",required = true)Double lowLong,
			@RequestParam(value="highLong",required = true)Double highLong,
			@RequestParam(value="lowLa",required = true)Double lowLa,
			@RequestParam(value="highLa",required = true)Double highLa,
			HttpServletRequest request) {
		ImageLog imageLog=new ImageLog();
		imageLog.setDate(new Date());
		imageLog.setOp("SEARCH");
		imageLog.setUsername(username);
		imageLogMapper.InsertImageLog(imageLog);
		return imageMapper.SearchImage(location, lowLa, lowLong, highLa, highLong);
	}
	@RequestMapping("/delete/{id}")
	void deleteImage(@PathVariable("id")Long id,
@RequestParam(value="username",required = true)String username) {
		imageMapper.deleteImageById(id);
		
		ImageLog imageLog=new ImageLog();
		imageLog.setDate(new Date());
		imageLog.setOp("DELETE");
		imageLog.setUsername(username);
	}
	@RequestMapping("/update/{id}")
	void updateImage(@PathVariable(value="id")Long id,
			@RequestParam(value="username",required = true)String username,
			@RequestParam(value="location",required = true)String location,
			@RequestParam(value="latitude",required = true)Double latitude,
			@RequestParam(value="longtitude",required = true)Double longtitude)
	{
		Image image=new Image();
		image.setId(id);
		image.setUsername(username);
		image.setLatitude(latitude);
		image.setLongtitude(longtitude);
		image.setLocation(location);
		imageMapper.updateImage(image);
		ImageLog imageLog=new ImageLog();
		imageLog.setDate(new Date());
		imageLog.setOp("UPDATE");
		imageLog.setUsername(username);
	}

}
