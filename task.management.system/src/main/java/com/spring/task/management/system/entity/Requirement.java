package com.spring.task.management.system.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "requirements")
@NoArgsConstructor
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
    private String requirementDescription;

    @Column
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "product")
    @ToString.Exclude
    private Product product;

    public Requirement(String requirementName, String requirementDescription, Product product) {
        this.requirementName = requirementName;
        this.requirementDescription = requirementDescription;
        this.product = product;
    }
}
