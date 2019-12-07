package com.springboot.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails extends MyUser implements UserDetails {
public MyUserDetails(MyUser myUser) {
	this.setId(myUser.getId());
	this.setName(myUser.getName());
	this.setUsername(myUser.getUsername());
	this.setPassword(myUser.getPassword());
	this.setRole(myUser.getRole());
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
	list.add(new SimpleGrantedAuthority("ROLE_"+this.getRole()));
	return list;
}
@Override
public boolean isAccountNonExpired() {
	return true;
}
@Override
public boolean isAccountNonLocked() {
	return true;
}
@Override
public boolean isCredentialsNonExpired() {
	return true;
}
@Override
public boolean isEnabled() {
	return true;
}
}
