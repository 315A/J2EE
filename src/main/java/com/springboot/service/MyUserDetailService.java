package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.domain.MyUser;
import com.springboot.domain.MyUserDetails;
import com.springboot.mapper.MyUserMapper;

@Configuration
@Service
public class MyUserDetailService implements UserDetailsService{
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	MyUserMapper myUserMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyUser user=myUserMapper.getOneByUsername(username);
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		System.out.print(user);
		if (user == null) throw new UsernameNotFoundException("用户名为" + username + "的用户不存在");
		return  new MyUserDetails(user);
	}

}
