package com.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.springboot.domain.Image;
import com.springboot.domain.MyUser;

public interface ImageMapper {
	final String TABLE_NAME=" IMAGE ";
	@Insert({"insert into"+TABLE_NAME+"(DATE,IMG,THUMB_IMG,USERNAME,LOCATION,LONGTITUDE,LATITUDE) values(" +
    "#{date,jdbcType=TIMESTAMP},#{img,jdbcType=BLOB},#{thumbImg,jdbcType=BLOB},"
    + "#{username,jdbcType=VARCHAR},#{location,jdbcType=VARCHAR},"
    + "#{longtitude,jdbcType=DOUBLE},#{latitude,jdbcType=DOUBLE})"})
	void InsertImage(Image image);
	
	@Select("SELECT ID,IMG,THUMB_IMG,DATE,USERNAME,LOCATION,LONGTITUDE,LATITUDE FROM"+TABLE_NAME+"where( LOCATION like"
			+ " CONCAT(CONCAT('%',#{location}),'%')) and (LATITUDE between "
			+ "#{lowLa} and #{highLa}) and (LONGTITUDE between #{lowLong} and #{highLong})")
	@Results(
			{@Result(property="id",column="ID",jdbcType = JdbcType.BIGINT,id = true),
				@Result(property="img",column="IMG",jdbcType = JdbcType.BLOB),
				@Result(property="thumbImg",column="THUMB_IMG",jdbcType = JdbcType.BLOB),
				@Result(property="date",column="DATE",jdbcType = JdbcType.TIMESTAMP),
				@Result(property="username",column="USERNAME",jdbcType = JdbcType.VARCHAR),
				@Result(property="location",column="LOCATION",jdbcType = JdbcType.VARCHAR),
				@Result(property="longtitude",column="LONGTITUDE",jdbcType = JdbcType.DOUBLE),
				@Result(property="latitude",column="LATITUDE",jdbcType = JdbcType.DOUBLE)})
    List<Image> SearchImage(@Param("location")String location,@Param("lowLa")Double lowLa,
    		@Param("lowLong")Double lowLong,@Param("highLa")Double highLa,
    		@Param("highLong")Double highLong);
	
	@Select("SELECT ID,IMG,DATE,USERNAME,LOCATION,LONGTITUDE,LATITUDE FROM"+TABLE_NAME+"where ID=#{id}")
	@Results(
	{@Result(property="id",column="ID",jdbcType = JdbcType.BIGINT,id = true),
	@Result(property="img",column="IMG",jdbcType = JdbcType.BLOB),
	@Result(property="date",column="DATE",jdbcType = JdbcType.TIMESTAMP),
	@Result(property="username",column="USERNAME",jdbcType = JdbcType.VARCHAR),
	@Result(property="location",column="LOCATION",jdbcType = JdbcType.VARCHAR),
	@Result(property="longtitude",column="LONGTITUDE",jdbcType = JdbcType.DOUBLE),
	@Result(property="latitude",column="LATITUDE",jdbcType = JdbcType.DOUBLE)})
    Image getImageById(@Param("id")Long id);
	
	@Delete("delete from"+TABLE_NAME+"where ID=#{id}")
	void deleteImageById(Long id);
	
	@Update("update"+TABLE_NAME+"SET LOCATION=#{location,jdbcType=VARCHAR},LONGTITUDE=#{longtitude},LATITUDE=#{latitude} where ID=#{id}")
	void updateImage(Image image);
}
