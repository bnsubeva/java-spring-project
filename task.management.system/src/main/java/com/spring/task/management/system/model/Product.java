package com.spring.task.management.system.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long productId;

    @Column
    @NonNull
    @NotNull
    private String productName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productOwnerId", referencedColumnName = "userId")
    private User productOwner;

    @OneToMany(targetEntity = User.class, mappedBy="productDevelops",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> tasks;

    @OneToMany(targetEntity = Requirement.class, mappedBy = "product",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Requirement> requirements;

}
