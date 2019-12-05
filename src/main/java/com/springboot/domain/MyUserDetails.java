package com.springboot.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails extends MyUser implements UserDetails {
public MyUserDetails(MyUser myUser) {
	this.setId(myUser.getId());
	this.setName(myUser.getName());
	this.setUsername(myUser.getUsername());
	this.setPassword(myUser.getPassword());
	this.setRoles(myUser.getRoles());
	
	
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	return null;
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
