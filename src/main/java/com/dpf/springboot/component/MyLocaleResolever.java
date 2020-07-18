package com.dpf.springboot.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @program:spring-boot-web-resultful
 * @description:可以在连接上携带区域信息
 * @autor:dpf
 * @create:2020-07-11 13:41
 **/
public class MyLocaleResolever implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l= request.getParameter("l");
        if(l==null){
            l="zh_CN";
        }
        Locale locale = null;
        if(!StringUtils.isEmpty(l)){
            String [] split = l.split("_");
            locale =new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }


}