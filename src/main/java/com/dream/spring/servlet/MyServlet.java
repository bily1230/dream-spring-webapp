package com.dream.spring.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ning on 2017/8/29.
 */
public class MyServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        System.out.print("myServlet");
        System.out.print(request.getParameter("hello"));
    }
}
