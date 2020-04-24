package com.guo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class Login {

    @RequestMapping("/login")
    public String  Login(HttpServletRequest request, ModelAndView modelAndView){
       return "登录成功";
    }
}
