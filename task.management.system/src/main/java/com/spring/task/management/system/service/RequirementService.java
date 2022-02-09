package com.spring.task.management.system.service;

import com.spring.task.management.system.model.Requirement;

import java.util.List;

public interface RequirementService {
    List<Requirement> getAllRequirements();

    Requirement addRequirement(Requirement requirement);

    Requirement getRequirementByRequirementId(Long requirementId);
    /*

    List<Requirement> getRequirementsByProductId(Long productId);

     */

    Requirement updateRequirement(Requirement requirement);
    
    void deleteRequirementById(Long requirementId);
}
