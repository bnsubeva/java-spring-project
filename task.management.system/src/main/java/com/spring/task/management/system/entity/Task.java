package com.spring.task.management.system.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "tasks")
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long taskId;

    @NotNull
    @NonNull
    private String taskName;

    @NotNull
    @NonNull
    private String type;

    @NotNull
    @NonNull
    private String description;

    @NotNull
    @NonNull
    private String status;

    @NonNull
    private String priority;

    @OneToOne(optional = false, orphanRemoval = true, cascade = CascadeType.ALL )
    @JoinColumn(name = "task_result_id")
    private TaskResult taskResult;

    @ManyToOne
    private Sprint sprint;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User assignedTo;

    @ManyToOne
    private User assignedFrom;

    @Transient
    private String sprintName;

    @Transient
    private String productName;

    @Transient
    private String assignedToName;

}