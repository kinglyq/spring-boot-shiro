package com.github.kinglyq.springbootshiro.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Table(name = "sys_role",
        uniqueConstraints = {@UniqueConstraint(name = "uni_role_name", columnNames = "name")}
)
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private Set<User> users = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }
}
