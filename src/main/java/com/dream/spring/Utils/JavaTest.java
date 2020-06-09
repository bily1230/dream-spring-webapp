package com.dream.spring.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		
		list.addAll(Arrays.asList("1","2"));
		list.add("2");
		for(int i=0;i<6;i++){
			System.out.println(list.toString());
			
		}
		
		boolean is = false;
		boolean no = false;
		if(is == no){
			System.out.println("000");
		}
	}

}
