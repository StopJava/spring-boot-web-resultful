package com.dpf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program:spring-boot-web-resultful
 * @description:
 * @autor:dpf
 * @create:2020-07-11 19:37
 **/
@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username
                        , @RequestParam("password") String password
                        , Map<String,Object>map, HttpSession session)throws Exception{
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
        //登录成功,重定向
            session.setAttribute("loginuser",username);
            return "redirect:/main.html";
        }
        //登录失败
        map.put("msg","用户名密码错误!");
        return "login";
    }
}
