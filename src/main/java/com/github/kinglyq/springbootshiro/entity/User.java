package com.github.kinglyq.springbootshiro.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * @author kinglyq
 */
@Getter
@Setter
@ToString
@Entity
@RequiredArgsConstructor
@Table(name = "sys_user", uniqueConstraints = {@UniqueConstraint(name = "uni_username", columnNames = "username")})
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_user_permission",
            foreignKey = @ForeignKey(name = "fk_user_permission"),
            inverseForeignKey = @ForeignKey(name = "fk_permission_user")
    )
    @ToString.Include
    private Set<Permission> permissions = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_user_role",
            foreignKey = @ForeignKey(name = "fk_user_role"),
            inverseForeignKey = @ForeignKey(name = "fk_role_user")
    )
    @ToString.Include
    private Set<Role> roles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
