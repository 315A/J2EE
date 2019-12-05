package com.springboot.mapper;

import java.sql.JDBCType;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.springboot.domain.MyUser;

public interface MyUserMapper {
	

	final String TABLE_NAME=" USER ";
	@Select("select * from"+TABLE_NAME)
	@Results(
	{@Result(property="id",column="ID",jdbcType = JdbcType.BIGINT,id = true),
	@Result(property="username",column="USERNAME",jdbcType = JdbcType.VARCHAR),
	@Result(property="password",column="PASSWORD",jdbcType = JdbcType.VARCHAR),
	@Result(property="name",column="NAME",jdbcType = JdbcType.VARCHAR)})
	List<MyUser> getAll();
	
	@Select("SELECT * FROM"+TABLE_NAME+"WHERE ID = #{id}")
	@Results(
	{@Result(property="id",column="ID",jdbcType = JdbcType.BIGINT,id = true),
	@Result(property="username",column="USERNAME",jdbcType = JdbcType.VARCHAR),
	@Result(property="password",column="PASSWORD",jdbcType = JdbcType.VARCHAR),
	@Result(property="name",column="NAME",jdbcType = JdbcType.VARCHAR)})
    MyUser getOneById(long id);
	
	
	@Select("SELECT * FROM"+TABLE_NAME+"WHERE USERNAME = #{username}")
	@Results(
	{@Result(property="id",column="ID",jdbcType = JdbcType.BIGINT,id = true),
	@Result(property="username",column="USERNAME",jdbcType = JdbcType.VARCHAR),
	@Result(property="password",column="PASSWORD",jdbcType = JdbcType.VARCHAR),
	@Result(property="name",column="NAME",jdbcType = JdbcType.VARCHAR)})
    MyUser getOneByUsername(String username);
	
	@Insert("INSERT INTO "+TABLE_NAME+"(USERNAME,PASSWORD,NAME) "
			+ "VALUES(#{username}, #{password}, #{name})")
    void insert(MyUser user);
}
