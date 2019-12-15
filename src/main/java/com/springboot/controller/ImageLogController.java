package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.domain.ImageLog;
import com.springboot.mapper.ImageLogMapper;

@RestController
@RequestMapping("/log")
public class ImageLogController {
	@Autowired
	ImageLogMapper imageLogMapper;
	@RequestMapping("/all")
	List<ImageLog>getAllLog(){
		return imageLogMapper.getAllImageLog();
	}
}
