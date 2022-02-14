package com.spring.task.management.system.controller;

import com.spring.task.management.system.entity.Sprint;
import com.spring.task.management.system.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sprints")
public class SprintController {

    private final SprintService sprintService;

    @Autowired
    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    @GetMapping
    public String getSprints(Model model) {
        model.addAttribute("sprints", sprintService.getAllSprints());
        return "sprint";
    }

    @GetMapping("/sprint-form")
    public String getSprintForm(Model model) {
        if (!model.containsAttribute("sprint")) {
            model.addAttribute("sprint", new Sprint());
        }
        return "sprint-form";
    }

    @PostMapping("/sprint-form")
    public String addSprint(@ModelAttribute Sprint sprint) {
        sprintService.addSprint(sprint);
        return "redirect:";
    }
}
