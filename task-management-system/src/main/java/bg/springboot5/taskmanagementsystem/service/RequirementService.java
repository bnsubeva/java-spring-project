package bg.springboot5.taskmanagementsystem.service;

import bg.springboot5.taskmanagementsystem.model.Requirement;


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
