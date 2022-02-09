package com.spring.task.management.system.model;

import bg.springboot5.taskmanagementsystem.enums.Priority;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "tasks")
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long taskId;

    @Column
    @NotNull
    @NonNull
    private String taskName;

    @Column
    @NotNull
    @NonNull
    private String type;

    @Column
    @NotNull
    @NonNull
    @Size(min = 10, max = 2048, message = "Description must be between 10 and 2048 characters long")
    private String description;

    @Column
    @NotNull
    @NonNull
    private String status;

    @Column
    @NonNull
    private Priority priority;

    @OneToOne(optional = false)
    @JoinColumn
    private TaskResult taskResult;

    @ManyToOne
    @JoinColumn
    private Sprint sprint;

    @ManyToOne
    @JoinColumn(name="assigned_to_name")
    private User assignedTo;

    @ManyToOne
    @JoinColumn(name="assigned_from_name")
    private User assignedFrom;

}