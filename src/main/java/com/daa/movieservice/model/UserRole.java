package com.daa.movieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "t_user_roles")
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    private Long id;

    @Column(name = "role_type")
    private String roleType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_users_t_user_roles", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @EqualsAndHashCode.Exclude
    private Set<User> users;
}
