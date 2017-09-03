package com.dream.spring.domain;

import java.io.Serializable;

/**
 * Created by ning on 2017/9/3.
 */
public class User implements Serializable {

    private String name;
    private String age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }
}
