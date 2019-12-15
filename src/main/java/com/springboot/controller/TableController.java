package com.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
			List<Map > map=new ArrayList<Map >();
			Map<String,Object> image=new HashMap<String,Object>();
			image.put("TABLE_NAME", "IMAGE");
			image.put("TABLE_ROWS", tableMapper.showImageInfo());
			Map<String,Object> imgLog=new HashMap<String,Object>();
			imgLog.put("TABLE_NAME", "IMG_LOG");
			imgLog.put("TABLE_ROWS", tableMapper.showImgLogInfo());
			Map<String,Object> user=new HashMap<String,Object>();
			user.put("TABLE_NAME", "USER");
			user.put("TABLE_ROWS", tableMapper.showUserInfo());
			map.add(image);map.add(imgLog);map.add(user);
		
		return map;
	}
}
