package com.github.kinglyq.springbootshiro.service;

import com.github.kinglyq.springbootshiro.entity.User;

public interface UserService {

    void saveUser(User user);

    User getUser(String username);

    void addRole(String username, String roleName);

    void addPermission(String username, String permissionName);

    void deleteRole(String username, String roleName);

    void deletePermission(String username, String permissionName);

}
