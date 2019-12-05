package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.mapper.ImageMapper;

public class ImageService {
	@Autowired
	ImageMapper imageMapper;
}
