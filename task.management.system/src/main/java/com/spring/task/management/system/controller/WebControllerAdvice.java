package com.spring.task.management.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ControllerAdvice
public class WebControllerAdvice {

    @ExceptionHandler
    public ModelAndView handleExceptions(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.getModel().put("message", ex.getMessage());
        return modelAndView;
    }

}
