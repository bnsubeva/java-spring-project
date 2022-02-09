package com.spring.task.management.system.model;

import bg.springboot5.taskmanagementsystem.enums.Position;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
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
    @NonNull
    @NotNull
    private String userName;

    @Column
    @NonNull
    @NotNull
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}")
    private String password;

    @Column
    @NonNull
    @NotNull
    @Size(min = 10, max = 2048, message = "Email must be between 10 and 2048 characters long")
    private String email;

    @OneToMany(targetEntity = Task.class, mappedBy = "assignedTo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> tasks;

    @OneToOne(optional = false)
    @JoinColumn
    private Product productOwn;

    @ManyToOne
    @JoinColumn(name="product_develops_name")
    private Product productDevelops;

    @ManyToOne(optional = false)
    @JoinColumn(name = "team_id")
    private Team team;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime created;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime modified;

}


