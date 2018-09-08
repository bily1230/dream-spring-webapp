package com.dream.spring.manager;

import org.springframework.stereotype.Controller;

/**
 * Created by ning on 2018/7/2.
 */
@Controller
public class AspectJManager {

    public void show(String name) {
        System.out.println( "aspectJ:"+ name );
    }
}
