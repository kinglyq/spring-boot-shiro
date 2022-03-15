package com.github.kinglyq.springbootshiro.service.impl;

import com.github.kinglyq.springbootshiro.entity.Permission;
import com.github.kinglyq.springbootshiro.entity.Role;
import com.github.kinglyq.springbootshiro.entity.User;
import com.github.kinglyq.springbootshiro.repo.PermissionRepo;
import com.github.kinglyq.springbootshiro.repo.RoleRepo;
import com.github.kinglyq.springbootshiro.repo.UserRepo;
import com.github.kinglyq.springbootshiro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final RoleRepo roleRepo;

    private final PermissionRepo permissionRepo;

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findUserByUsername(username);
    }

    @Override
    public void addRole(String username, String roleName) {
        User user = userRepo.findUserByUsername(username);
        if (user == null) {
            return;
        }
        Role role = roleRepo.findByName(roleName);
        if (role != null) {
            user.getRoles().add(role);
        }
    }

    @Override
    public void addPermission(String username, String permissionName) {
        User user = userRepo.findUserByUsername(username);
        if (user == null) {
            return;
        }
        Permission permission = permissionRepo.findByName(permissionName);
        if (permission != null) {
            user.getPermissions().add(permission);
        }
    }

    @Override
    public void deleteRole(String username, String roleName) {
        User user = userRepo.findUserByUsername(username);
        if (user == null) {
            return;
        }
        user.getRoles().removeIf(role -> role.getName().equals(roleName));
    }

    @Override
    public void deletePermission(String username, String permissionName) {
        User user = userRepo.findUserByUsername(username);
        if (user == null) {
            return;
        }
        user.getPermissions().removeIf(permission -> permission.getName().equals(permissionName));
    }

}
