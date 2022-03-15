package com.github.kinglyq.springbootshiro.repo;

import com.github.kinglyq.springbootshiro.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RoleRepoTest {

    @Resource
    private RoleRepo roleRepo;

    @Test
    void addRole() {
        List<Role> roleList = new ArrayList<>() {{
            add(new Role("admin"));
            add(new Role("general"));
            add(new Role("colonel"));
        }};

        roleRepo.saveAll(roleList);
    }
}