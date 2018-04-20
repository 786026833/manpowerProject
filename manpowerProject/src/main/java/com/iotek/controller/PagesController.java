package com.iotek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/4/20.
 */
@Controller
public class PagesController {
    @RequestMapping("/skipLogin")
    public String skipLogin(){
        return "login";

    }
    @RequestMapping("/skipUserRegister")
    public String skipUserRegister(){
        return "userRegister";
    }
}
