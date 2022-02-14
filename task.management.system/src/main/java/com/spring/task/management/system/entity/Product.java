package com.spring.task.management.system.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long productId;

    @Column
    @NonNull
    @NotNull
    private String productName;

    @NotNull
    @NonNull
    private String description;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productOwnerId", referencedColumnName = "userId")
    private User productOwner;
*/
    /*@OneToMany(targetEntity = User.class, mappedBy="productDevelops",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> tasks;*/

    @OneToMany(targetEntity = Requirement.class, mappedBy = "product",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Requirement> requirements;

}
