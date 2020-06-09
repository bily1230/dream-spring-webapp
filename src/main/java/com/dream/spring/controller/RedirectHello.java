package com.dream.spring.controller;

import com.dream.spring.domain.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ning on 2017/9/3.
 */

@Controller
@RequestMapping("/redirectHello")
public class RedirectHello {
    @RequestMapping("/sayName/{name}")
    public void sayName(@PathVariable("name")String name, @RequestParam("age")String age,Model model, User user){

        if(model.containsAttribute("user")){

            System.out.println("redirect******:"+user.getName());
            System.out.println("redirect******:"+user.getAge());
        }
        System.out.println("redirect:"+name);
        System.out.println("redirect:"+age);
    }
}
