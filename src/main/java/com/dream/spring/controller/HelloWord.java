package com.dream.spring.controller;

import org.springframework.stereotype.Component;

/**
 * Created by ning on 2017/8/20.
 */

@Component("helloScan")
public class HelloWord {
    private String name;
    private static int count;


    public  HelloWord(){
        name = "000";
        count++;
    }
    public HelloWord(String name){
        this.name = name;
        count++;
    }
    public void readWord(){
        System.out.println("中国梦！作为中国人"+name +"---"+count);
    }
}
