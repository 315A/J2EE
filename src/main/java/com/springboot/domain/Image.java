package com.springboot.domain;

import java.util.Date;

public class Image {

    private Long id;
    private Date date;
    private byte[] img;
    private byte[] thumbImg;
    private String location;
	private Double latitude;
    private Double longtitude;
    private Integer type;
    public Long getId() {
		return id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public byte[] getThumbImg() {
		return thumbImg;
	}
	public void setThumbImg(byte[] thumbImg) {
		this.thumbImg = thumbImg;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String username;
}
