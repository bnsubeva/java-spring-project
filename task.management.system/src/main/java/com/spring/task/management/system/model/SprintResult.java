package com.spring.task.management.system.model;

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
@Builder
public class SprintResult {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long sprintResultId;

    @Column
    @NotNull
    @NonNull
    @Size(min = 10, max = 2048, message = "Description must be between 10 and 2048 characters long")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sprint_id", referencedColumnName = "sprintId")
    private Sprint sprint;

    @Column
    private boolean completed;

}

