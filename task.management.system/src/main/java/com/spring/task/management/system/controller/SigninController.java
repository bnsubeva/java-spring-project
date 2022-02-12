package com.spring.task.management.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {
    @RequestMapping(value = "login")
    public String login() {
        return "login";
    }
}