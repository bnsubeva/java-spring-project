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
@Table(name = "sprintResults")
public class SprintResult {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long sprintResultId;

    @NotNull
    @NonNull
    private String description;

    private boolean completed;

    public SprintResult() {
        this.description = "Still no result";
    }

}

