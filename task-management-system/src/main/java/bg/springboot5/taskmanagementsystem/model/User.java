package bg.springboot5.taskmanagementsystem.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    String name;
    @Column(name = "position")
    String position;
    @Column(name = "password")
    String password;
    @Column(name = "email")
    String email;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
