package com.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface TableMapper {
		@Select("select TABLE_NAME,TABLE_ROWS from information_schema.TABLES where TABLE_SCHEMA=(select database())")
		List<Map> showInfo();
}
