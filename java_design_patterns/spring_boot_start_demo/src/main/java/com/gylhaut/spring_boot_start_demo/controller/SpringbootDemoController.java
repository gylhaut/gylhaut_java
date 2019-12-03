package com.gylhaut.spring_boot_start_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringbootDemoController {
    @RequestMapping(value ="/hello")
    @ResponseBody
    public String getStart(){
        return "hello spring boot";
    }
}
