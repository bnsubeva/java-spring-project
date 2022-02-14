package com.spring.task.management.system.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sprints")
@Builder
public class Sprint {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long sprintId;

    @Column
    @NotNull
    @NonNull
    private String sprintName;

    @Column
    @NotNull
    @NonNull
    @Size(min = 10, max = 2048, message = "Description must be between 10 and 2048 characters long")
    private String description;

    @Column
    @NotNull
    @NonNull
    private boolean active;

    @OneToOne(optional = false)
    private SprintResult sprintResult;

    @OneToMany(targetEntity = Task.class, mappedBy = "sprint", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> tasks;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime created;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime modified;

}

