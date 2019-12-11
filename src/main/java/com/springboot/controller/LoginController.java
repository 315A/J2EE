package com.springboot.controller;

import javax.annotation.Generated;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {
	@RequestMapping("/success")
	public String ss() {
		return "success";
	}
	@RequestMapping("/failure")
	public String ff() {
		return "failure";
	}

}
