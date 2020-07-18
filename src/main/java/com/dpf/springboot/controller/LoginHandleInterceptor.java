package com.dpf.springboot.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program:spring-boot-web-resultful
 * @description:
 * @autor:dpf
 * @create:2020-07-11 22:46
 **/
public class LoginHandleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginuser = request.getSession().getAttribute("loginuser");
        if(loginuser!=null){
            return true;
        }
            request.setAttribute("msg","权限不足");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
