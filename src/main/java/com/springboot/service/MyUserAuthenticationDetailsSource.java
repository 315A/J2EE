package com.springboot.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.springboot.domain.MyUserAuthenticationProvider;
@Component
public class MyUserAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
	@Override
	public WebAuthenticationDetails  buildDetails(HttpServletRequest request) {
	return new WebAuthenticationDetails(request);
}
}
