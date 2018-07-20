package com.chasel.girl.controller;

import com.chasel.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XieLongzhen
 * @date 2018/7/9 13:08
 */
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girl;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
//        return "Hello Spring Boot!";
        return girl.getCupSize();
    }
}
