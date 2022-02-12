package com.spring.task.management.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(value = "homeSignedIn")
    public String homeSignedIn() {
        return "homeSignedIn";
    }
    @RequestMapping(value = "homeNotSignedIn")
    public String homeNotSignedIn() {
        return "homeNotSignedIn";
    }
    @RequestMapping(value = "menu")
    public String menu() {
        return "fragments/menu";
    }
}
