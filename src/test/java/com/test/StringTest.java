/**
 * Project:dream-spring-webapp
 * File:StringTest.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.test;

import org.junit.Test;

/**
 *.		
 * @author nb
 * @date 2018年10月10日
 */
public class StringTest {
	int hash = 0;
	@Test
	public void test() {
		String abc = "xbka";
		int code = hashCode(abc.toCharArray());
		char[] value = abc.toCharArray();
		for (int i = 0; i < value.length; i++) {
        	System.out.println(value[i]);
        	hash = value[i];
            System.out.println(hash);
        }
		
	}
	
	
	 public int hashCode(char[] value) {
	        int h = hash;
	        if (h == 0 && value.length > 0) {
	            char val[] = value;

	            for (int i = 0; i < value.length; i++) {
	            	System.out.println(val[i]);
	                h = 31 * h + val[i];
	            }
	            hash = h;
	        }
	        return h;
	    }
}
