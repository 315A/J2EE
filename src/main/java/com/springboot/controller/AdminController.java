package com.springboot.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.domain.MyUser;
import com.springboot.mapper.MyUserMapper;


@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	MyUserMapper myUserMapper;
	
    @RequestMapping(value="")
    public String welcome()
    {
    	return "hello in /admin";
    }
    @RequestMapping(value="/{id}",method =RequestMethod.PUT)
    public String getAccountById(@PathVariable("id") Long id)
    {
    	System.out.println(id);
    	MyUser myUser=myUserMapper.getOneById(id);
    	return "cc";
    }
    @RequestMapping(value="/all")
    public List<MyUser> getAllAccount()
    {
    	return myUserMapper.getAll();
    }


}
