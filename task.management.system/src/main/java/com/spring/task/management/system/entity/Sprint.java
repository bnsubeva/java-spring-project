package com.spring.task.management.system.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "sprints")
@NoArgsConstructor
public class Sprint {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long sprintId;

    @NotNull
    @NonNull
    private String sprintName;

    @NotNull
    @NonNull
    private String description;

    private boolean active = true;

    @OneToOne
    private SprintResult sprintResult;

    @OneToMany(mappedBy = "sprint", fetch = FetchType.EAGER)
    private Set<Task> tasks = new HashSet<>();

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime created;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime modified;

}

