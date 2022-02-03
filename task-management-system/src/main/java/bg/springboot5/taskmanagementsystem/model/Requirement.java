package bg.springboot5.taskmanagementsystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "requirements")
@Builder
public class Requirement {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long requirementId;

    @Column
    String requirementName;

    @ManyToOne
    @JoinColumn(name="product")
    Product product;
}
