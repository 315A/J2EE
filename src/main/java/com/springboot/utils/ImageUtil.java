package com.springboot.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import net.coobird.thumbnailator.Thumbnails;

public class ImageUtil {
public static byte[] generateThumb(byte[] img) throws Exception{
	byte[] thumbImg=null;
	double wScale=0.5,hScale=0.5;
	InputStream ins = new ByteArrayInputStream(img);
	ByteArrayOutputStream baos=new ByteArrayOutputStream();
	Thumbnails.of(ins).scale(wScale, hScale).toOutputStream(baos);
    thumbImg = baos.toByteArray();
    ins.close();
    baos.close();
	return thumbImg;
}
}
