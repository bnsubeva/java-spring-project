package com.spring.task.management.system.entity;

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
@Table(name = "taskResults")
@Builder
public class TaskResult {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long taskResultId;

    @Column
    @NotNull
    @NonNull
    @Size(min = 10, max = 2048, message = "Description must be between 10 and 2048 characters long")
    private String description;

    //@MapsId
    @OneToOne( optional = false, fetch = FetchType.LAZY, mappedBy = "taskResult")
    private Task task;

    @Column
    private boolean completed;

}
