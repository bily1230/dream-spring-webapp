package com.dream.spring.controller;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

/**
 * Created by ning on 2017/8/20.
 */

@Controller
@RequestMapping("helloWord")
public class HelloWord {

    @RequestMapping(value="/{id}/readWord" ,method = RequestMethod.GET)
    public String readWord(@PathVariable("id") String id, @RequestParam("name")String name,
                           Model model, HttpServletRequest request){

        System.out.println("中国梦！作为中国人"+id+"---"+name+"--"+request.getParameter("age"));
        model.addAttribute("name","小寒");
        return "return";
    }
}
