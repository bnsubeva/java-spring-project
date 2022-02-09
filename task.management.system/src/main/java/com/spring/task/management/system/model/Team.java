package com.spring.task.management.system.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "teams")
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

    @OneToMany(targetEntity = User.class, mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> users;

}
