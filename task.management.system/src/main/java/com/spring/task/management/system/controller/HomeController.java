package com.spring.task.management.system.controller;

import com.spring.task.management.system.entity.User;
import com.spring.task.management.system.service.TaskService;
import com.spring.task.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

   private final UserService userService;
   private final TaskService taskService;

   @Autowired
   public HomeController(UserService userService, TaskService taskService) {
      this.userService = userService;
      this.taskService = taskService;
   }

   @GetMapping("/")
   public String index(Authentication auth, Model model) {
      model.addAttribute("listTasks", taskService.getAllTasks());
      return auth.getPrincipal() != null ? "homeSignedIn" : "homeNotSignedIn";
   }

   @GetMapping("/profile")
   public String viewProfile(Authentication auth, Model model) {
      User user = userService.findByUsername(((User)auth.getPrincipal()).getUsername());
      model.addAttribute("username", user.getUsername());
      model.addAttribute("email", user.getEmail());
      model.addAttribute("listTasks", user.getTasks());
      return "profile";
   }

   @GetMapping("/history")
   public String history() {
      return "history";
   }

}






