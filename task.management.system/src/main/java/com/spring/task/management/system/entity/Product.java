package com.spring.task.management.system.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long productId;

    @Column(unique = true)
    @NonNull
    @NotNull
    private String productName;

    @NotNull
    @NonNull
    private String description;

    @OneToOne
    private User productOwner;

    @OneToMany(targetEntity = Requirement.class, mappedBy = "product",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Requirement> requirements = new ArrayList<>();

    @OneToMany(mappedBy = "sprint", fetch = FetchType.EAGER)
    private Set<Task> tasks = new HashSet<>();

    @Transient
    private String requirementList;

}
