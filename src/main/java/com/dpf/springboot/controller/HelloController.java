package com.dpf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;


/**
 * @program:spring-boot-web-resultful
 * @description:
 * @autor:dpf
 * @create:2020-07-10 15:01
 **/
@Controller
@RequestMapping("show")
public class HelloController {
    @RequestMapping("/hello")
    String hello()throws Exception{
        return "hello Springboot";
    }
    @RequestMapping("/success")
    String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
