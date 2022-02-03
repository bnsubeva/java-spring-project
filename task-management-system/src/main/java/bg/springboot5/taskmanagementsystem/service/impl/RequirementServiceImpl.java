package bg.springboot5.taskmanagementsystem.service.impl;

import bg.springboot5.taskmanagementsystem.model.Requirement;
import bg.springboot5.taskmanagementsystem.repository.RequirementRepository;
import bg.springboot5.taskmanagementsystem.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementServiceImpl implements RequirementService {
    private final RequirementRepository requirementRepository;

    @Autowired
    public RequirementServiceImpl(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    @Override
    public List<Requirement> getAllRequirements() {
        return requirementRepository.findAll();
    }

    @Override
    public Requirement addRequirement(Requirement requirement) {
        return requirementRepository.save(requirement);
    }

    @Override
    public Requirement getRequirementByRequirementId(Long requirementId) {
        return requirementRepository.findById(requirementId).get();
    }
/*
    @Override
    public List<Requirement> getRequirementsByProductId(Long productId) {

        return  requirementRepository.findAllById();
    }
*/
    @Override
    public Requirement updateRequirement(Requirement requirement) {
         return requirementRepository.save(requirement);
    }

    @Override
    public void deleteRequirementById(Long requirementId) {
    requirementRepository.deleteById(requirementId);
    }
}
