package com.github.kinglyq.springbootshiro.repo;

import com.github.kinglyq.springbootshiro.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kinglyq
 */
@Repository
public interface PermissionRepo extends JpaRepository<Permission, Long> {

    Permission findByName(String name);

}
