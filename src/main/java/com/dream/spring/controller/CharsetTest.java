package com.dream.spring.controller;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class CharsetTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		
		String name = "小明";
		byte[] arr = name.getBytes("utf-8");
		String newName = new String(arr,"utf-8");
		System.out.println(newName);
		
		
		Charset charset = Charset.forName("utf-8");
		ByteBuffer byteBuffer = charset.encode("黄三");
		CharBuffer charBuffer = charset.decode(byteBuffer);
		
		System.out.println(charBuffer);
		
		

	}

}
