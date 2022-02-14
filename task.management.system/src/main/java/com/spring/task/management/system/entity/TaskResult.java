package com.spring.task.management.system.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class TaskResult {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long taskResultId;

    @NotNull
    @NonNull
    private String description;

    private boolean completed;

    public TaskResult() {
        this.description = "Still no result";
    }

}