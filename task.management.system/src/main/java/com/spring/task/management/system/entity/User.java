package com.spring.task.management.system.entity;

import com.spring.task.management.system.enums.Position;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long userId;

    @NonNull
    @NotNull
    private String username;

    @NonNull
    @NotNull
    private String password;

    @NonNull
    @NotNull
    private String email;

    @NonNull
    @NotNull
    @Enumerated(EnumType.STRING)
    private Position position;

    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> tasks = new HashSet<>();

    /*@OneToOne
    @JoinColumn
    private Product productOwn;

    @ManyToOne
    private Product productDevelops;

    @ManyToOne
    private Team team;*/

    private boolean active = true;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime created = LocalDateTime.now();

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime modified = LocalDateTime.now();

    public User(String username, String password, String email, Position position) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.position = position;
    }

    @Transient
    public boolean isInRole(String role) {
        return this.position.getName().equals(role);
    }

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.position.getName()));
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return active;
    }

}