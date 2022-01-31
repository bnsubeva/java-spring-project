package bg.springboot5.taskmanagementsystem.model;

import bg.springboot5.taskmanagementsystem.enums.Priority;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    String taskName;

    @Column
    String type;

    @ManyToOne
    @JoinColumn(name="assigned_to_name")
    User assignedTo;

    @ManyToOne
    @JoinColumn(name="assigned_for_name")
    User assignedFrom;

    @Column
    String description;

    @Column
    String status;

    @Column
    Priority priority;

}
