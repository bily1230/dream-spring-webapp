package com.dream.spring.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

/**
 * Created by ning on 2017/8/20.
 */

@Controller
@RequestMapping("helloWord")
public class HelloWord {

    @RequestMapping(value="/readWord" ,method = RequestMethod.GET)
    public String readWord(){

        System.out.println("中国梦！作为中国人");
        return "return";
    }
}
