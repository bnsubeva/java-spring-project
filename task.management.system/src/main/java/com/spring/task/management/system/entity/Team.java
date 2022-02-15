package com.spring.task.management.system.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "teams")
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long teamId;

    @NonNull
    @NotNull
    @Size(min = 2, max = 60, message = "Team name must be between 2 and 60 characters long")
    private String teamName;

    @NonNull
    @NotNull
    @Size(min = 10, max = 2048, message = "Team description must be between 10 and 2048 characters long")
    private String teamDescription;

    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    public Team(String teamName, String teamDescription) {
        this.teamName = teamName;
        this.teamDescription = teamDescription;
    }

}
