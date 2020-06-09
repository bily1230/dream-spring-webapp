package com.dream.spring.controller.demo;

import com.dream.spring.manager.AspectJManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ning on 2018/7/2.
 */

@Controller
@RequestMapping("/aspect")
public class AspectJController {
    @Autowired
    private AspectJManager aspectJManager;

    @RequestMapping("/aop")
    public void testAop(){
        aspectJManager.show("李晗是笨蛋");
    }

}
