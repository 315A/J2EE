package com.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.springboot.domain.Image;
import com.springboot.domain.MyUser;

public interface ImageMapper {
	final String TABLE_NAME=" IMAGE ";
	@Insert({"insert into"+TABLE_NAME+"(DATE,IMG,THUMB_IMG,USERNAME,LONGTITUDE,LATITUDE) values(" +
    "#{date,jdbcType=TIMESTAMP},#{img,jdbcType=BLOB},#{thumbImg,jdbcType=BLOB},"
    + "#{username,jdbcType=VARCHAR},#{longtitude,jdbcType=DOUBLE},#{latitude,jdbcType=DOUBLE})"})
	void InsertImage(Image image);
	
	@Select("SELECT ID,THUMB_IMG FROM"+TABLE_NAME)
	@Results(
	{@Result(property="id",column="ID",jdbcType = JdbcType.BIGINT,id = true),
	@Result(property="thumbImg",column="THUMB_IMG",jdbcType = JdbcType.BLOB),
	@Result(property="img",column="THUMB_IMG",jdbcType = JdbcType.BLOB)})
    MyUser getAllThumb();
	
	@Select("SELECT ID,IMG,DATE,USERNAME,LONGTITUDE,LATITUDE FROM"+TABLE_NAME+"where ID=#{id}")
	@Results(
	{@Result(property="id",column="ID",jdbcType = JdbcType.BIGINT,id = true),
	@Result(property="img",column="IMG",jdbcType = JdbcType.BLOB),
	@Result(property="date",column="DATE",jdbcType = JdbcType.TIMESTAMP),
	@Result(property="username",column="USERNAME",jdbcType = JdbcType.VARCHAR),
	@Result(property="longtitude",column="LONGTITUDE",jdbcType = JdbcType.DOUBLE),
	@Result(property="latitude",column="LATITUDE",jdbcType = JdbcType.DOUBLE)})
    Image getImageById(long id);			
}
