package com.github.kinglyq.springbootshiro.repo;

import com.github.kinglyq.springbootshiro.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kinglyq
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
