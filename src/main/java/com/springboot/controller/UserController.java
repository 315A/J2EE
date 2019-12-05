package com.springboot.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.domain.MyUser;
import com.springboot.mapper.MyUserMapper;

@RestController
public class UserController {
	@Autowired
	MyUserMapper myUserMapper;
	@Autowired
    private PasswordEncoder passwordEncoder; //security提供的加密接口，先写着，等会配置
	@PostMapping("/doRegister")
    public String register(@RequestParam(value="name",required = true)String name,
    		@RequestParam(value="username",required = true)String username,
    		@RequestParam(value="password",required = true)String password) {
		MyUser user=new MyUser();
		user.setName(name);
		user.setPassword(passwordEncoder.encode(password));
		user.setUsername(username);
		myUserMapper.insert(user);
        return "注册成功";
    }

}
