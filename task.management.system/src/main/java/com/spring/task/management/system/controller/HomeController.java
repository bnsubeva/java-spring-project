package com.spring.task.management.system.controller;

import com.spring.task.management.system.model.Task;
import com.spring.task.management.system.service.TaskService;
import com.spring.task.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;


@Controller
class HomeController {

   @ModelAttribute("module")
   String module() {
      return "home";
   }

   @GetMapping("/")
   String index(Principal principal) {
      return principal != null ? "homeSignedIn" : "homeNotSignedIn";
   }

   @Autowired
   private TaskService taskService;

   @GetMapping("/homeSignedIn")
   public String viewHomePage(Model model) {
      model.addAttribute("listTasks", taskService.getAllTasks());
      return "homeSignedIn";
   }

   @GetMapping("/profile")
   public String viewProfile(Model model) {
      model.addAttribute("listTasks", taskService.getAllTasks());
      return "profile";
   }

}






