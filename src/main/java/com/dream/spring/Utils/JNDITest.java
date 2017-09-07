package com.dream.spring.Utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDITest {
	
	public static void main(String[] args) throws NamingException{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		//String str = (String) envCtx.lookupLink("logger/level");
		System.out.println("2");
	}

}
