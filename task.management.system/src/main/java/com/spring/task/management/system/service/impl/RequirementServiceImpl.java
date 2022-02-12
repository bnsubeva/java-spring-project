package com.spring.task.management.system.service.impl;

import com.spring.task.management.system.model.Requirement;
import com.spring.task.management.system.repository.RequirementRepository;
import com.spring.task.management.system.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
