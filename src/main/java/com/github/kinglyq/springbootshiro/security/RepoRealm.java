package com.github.kinglyq.springbootshiro.security;

import com.github.kinglyq.springbootshiro.entity.Permission;
import com.github.kinglyq.springbootshiro.entity.Role;
import com.github.kinglyq.springbootshiro.entity.User;
import com.github.kinglyq.springbootshiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@Configuration
public class RepoRealm extends AuthorizingRealm {

    public static final String REALM_NAME = "REPO_REALM";

    @Resource
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        User user = userService.getUser(username);

        if (user == null) {
            throw new UnknownAccountException("Account does not exist.");
        }

        char[] password = upToken.getPassword();

        SimpleAccount simpleAccount = new SimpleAccount(username, password, REALM_NAME);
        simpleAccount.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
        simpleAccount.setStringPermissions(user.getPermissions().stream().map(Permission::getName).collect(Collectors.toSet()));

        return simpleAccount;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        return null;
    }


}
