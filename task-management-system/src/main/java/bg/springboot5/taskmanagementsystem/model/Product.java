package bg.springboot5.taskmanagementsystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long productId;

    @Column
    String productName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productOwnerId", referencedColumnName = "userId")
    User productOwner;

    @OneToMany(targetEntity=User.class, mappedBy="productDevelops",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    Set<User> tasks=new HashSet<>();

    @OneToMany(targetEntity=Requirement.class, mappedBy="product",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Requirement> requirements = new HashSet<>();


}
