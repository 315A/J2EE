package com.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.springboot.domain.Image;
import com.springboot.domain.ImageLog;
@Mapper
public interface ImageLogMapper {
	final String TABLE_NAME=" IMG_LOG ";
	@Insert({"insert into"+TABLE_NAME+"(DATE,USERNAME,OP) values(" +
		    "#{date,jdbcType=TIMESTAMP},#{username,jdbcType=VARCHAR},#{op,jdbcType=VARCHAR})"})
			void InsertImageLog(ImageLog imageLog);
	
	@Select({"select * from"+TABLE_NAME})
	List<ImageLog> getAllImageLog();
}
