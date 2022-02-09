package com.spring.task.management.system.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@Table(name = "requirements")
public class Requirement {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long requirementId;

    @Column
    @NotNull
    @NonNull
    private String requirementName;

    @Column
    @NotNull
    @NonNull
    @Size(min = 10, max = 2048, message = "Description must be between 10 and 2048 characters long")
    private String requirementDescription;

    @Column
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;
}
