package com.spring.task.management.system.model;

import com.spring.task.management.system.enums.Priority;
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
    @Size(min = 10, max = 2048, message = "Description must be between 10 and 2048 characters long")
    private String description;

    @NotNull
    @NonNull
    private String status;

    @NonNull
    private Priority priority;

    @OneToOne( optional = false, orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL )
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

}
