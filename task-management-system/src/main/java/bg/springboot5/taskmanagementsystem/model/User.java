package bg.springboot5.taskmanagementsystem.model;

import bg.springboot5.taskmanagementsystem.enums.Position;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long userId;

    @Column
    String userName;

    @Column
    Position position;

    @Column
    String password;

    @Column
    String email;

    @OneToMany(targetEntity=Task.class, mappedBy="assignedTo",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Task> tasks=new HashSet<>();

    }


