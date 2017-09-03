package com.dream.spring.controller;


import com.dream.spring.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ning on 2017/8/20.
 */

@Controller
@RequestMapping("/helloWord")
public class HelloWord {

    @RequestMapping(value="/{age}/readWord" ,method = RequestMethod.POST)
    public String readWord(@PathVariable("age") String age, @RequestParam("name")String name,
                           RedirectAttributes model){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        System.out.println("中国梦！作为中国人---"+name+"--"+age);
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addFlashAttribute(user);
        return "redirect:/redirectHello/sayName/{name}";
    }
}
