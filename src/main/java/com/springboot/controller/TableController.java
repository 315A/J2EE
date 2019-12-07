package com.springboot.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mapper.TableMapper;
@RestController
public class TableController {
	@Autowired
TableMapper tableMapper;
	
	@RequestMapping("/info")
	List<Map> showInfo(){
		return tableMapper.showInfo();
	}
}
