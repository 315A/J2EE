package com.springboot.build;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//spring目录结构https://blog.csdn.net/u012675150/article/details/79351990
//mybatis https://blog.csdn.net/iku5200/article/details/82856621
//https://blog.csdn.net/loophome/article/details/88663705
@SpringBootApplication
//@ComponentScan(basePackages = {"com.springboot.mapper",
//		"com.springboot.build","com.springboot.config",
//		"com.springboot.controller","com.springboot.domain"
//}) 
//
//
@ComponentScan(basePackages = {"com.springboot"})
@MapperScan("com.springboot.mapper")
@EnableAutoConfiguration
public class Application{
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}

}