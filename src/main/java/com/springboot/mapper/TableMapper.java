package com.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface TableMapper {
		@Select("select count(1) from IMAGE")
		 Integer showImageInfo();
		
		@Select("select count(1) from IMG_LOG")
		 Integer showImgLogInfo();
		
		@Select("select count(1) from USER")
		 Integer showUserInfo();
}
