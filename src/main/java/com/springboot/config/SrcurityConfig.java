package com.springboot.config;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.springboot.domain.MyUserAuthenticationProvider;
import com.springboot.domain.MyUserDetails;
import com.springboot.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class SrcurityConfig extends WebSecurityConfigurerAdapter{
	
@Autowired
MyUserAuthenticationProvider userAuthenticationProvider;

@Autowired
MyUserDetailService userDetailService;


@Autowired
AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails>
myuserAuthenticationDetailsSource;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()    //认证请求
        .antMatchers("/register", "/doRegister", "/login", "/doLogin","/index.html").permitAll()     //除了***能够无认证访问
        .anyRequest().authenticated()    //任何请求都需要认证
        .and()
        .formLogin()
        .loginPage("/index.html")
        .loginProcessingUrl("/login")
        .defaultSuccessUrl("/index.html",true)
        .usernameParameter("username")
        .passwordParameter("password")
        .and()
        .csrf().disable();     //CSRF跨站请求伪造直接关闭
	}
	
	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider());
		}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider
	      = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailService);
	    authProvider.setPasswordEncoder(passwordEncoder());
	    return authProvider;
	}
	 @Override
	 public void configure(WebSecurity web){
	 //        platform.ignoring().antMatchers("/");
		 //静态资源可以不需要登录
	 }
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}

