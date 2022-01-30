package bg.springboot5.taskmanagementsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    String name;
    @Column(name = "type")
    String type;
    @Column(name = "assigned_to")
    String assignedTo;
    @Column(name = "assigned_from")
    String assignedFrom;
    @Column(name = "description")
    String description;
    @Column(name = "status")
    String status;
    @Column(name = "priority")
    int priority;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getAssignedFrom() {
        return assignedFrom;
    }

    public void setAssignedFrom(String assignedFrom) {
        this.assignedFrom = assignedFrom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
