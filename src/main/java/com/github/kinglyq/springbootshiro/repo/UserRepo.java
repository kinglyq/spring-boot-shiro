package com.github.kinglyq.springbootshiro.repo;

import com.github.kinglyq.springbootshiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kinglyq
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

}
