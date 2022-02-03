package bg.springboot5.taskmanagementsystem.controller;

import bg.springboot5.taskmanagementsystem.model.Requirement;
import bg.springboot5.taskmanagementsystem.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requirements")
public class RequirementController {
    private final RequirementService requirementService;
    @Autowired
    public RequirementController(RequirementService requirementService) {
        this.requirementService = requirementService;
    }

    @GetMapping
    public Requirement getRequirement() {
        return Requirement.builder().requirementName("Requirement").requirementId(577575L).build();
    }

}
