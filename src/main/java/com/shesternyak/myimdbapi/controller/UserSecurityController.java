package com.shesternyak.myimdbapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserSecurityController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
