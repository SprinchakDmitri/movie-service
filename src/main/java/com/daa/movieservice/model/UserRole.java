package com.daa.movieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "t_user_roles")
@AllArgsConstructor
@NoArgsConstructor
public class UserRole implements GrantedAuthority {
    @Id
    private Long id;

    @Column(name = "role_type")
  //  @Enumerated(EnumType.STRING)
    private String roleType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_users_t_user_roles", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @EqualsAndHashCode.Exclude
    private Set<User> users;

    @Override
    public String getAuthority(){
        return this.roleType.toString();
    }
}
