package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.springboot.domain.MyUserDetails;
import com.springboot.service.MyUserDetailService;
@Component
public class MyUserAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{
	@Autowired
	private MyUserDetailService userDetailService;
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		return null;
	}
	
	
	@Override
	 public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
		MyUserDetails userDetails = (MyUserDetails) userDetailService.loadUserByUsername(username);
		if(!userDetails.getPassword().equals(password)){
			 throw new BadCredentialsException("密码错误");
		}
		Object principalToReturn = userDetails;
		return this.createSuccessAuthentication(principalToReturn, authentication, userDetails);
	}

}
