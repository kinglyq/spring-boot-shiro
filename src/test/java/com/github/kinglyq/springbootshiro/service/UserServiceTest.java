package com.github.kinglyq.springbootshiro.service;

import com.github.kinglyq.springbootshiro.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void addUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("0000");

        userService.saveUser(user);

        System.out.println(user.getId());
    }

    @Test
    void getUser() {
        User tom = userService.getUser("tom");
        System.out.println(tom);
    }

    @Test
    void addRole() {
        userService.addRole("tom", "ROLE_ADMIN");
    }

    @Test
    void addPermission() {
    }

    @Test
    void deleteRole() {
        userService.deleteRole("tom", "colonel");
    }

    @Test
    void deletePermission() {
    }
}