package com.github.kinglyq.springbootshiro.security;

import com.github.kinglyq.springbootshiro.service.UserService;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.anon;

/**
 * @author kinglyq
 */
@Configuration
public class ShiroConfig {

   /* @Bean
    public SecurityManager securityManager() {
        return new DefaultWebSecurityManager();
    }*/

    @Bean
    public Realm realm(@Autowired UserService userService) {
        return new RepoRealm(userService);
    }

    /*@Bean
    protected CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }*/

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition filterChainDefinition = new DefaultShiroFilterChainDefinition();
        /*filterChainDefinition.addPathDefinition("/assets/**", anon.name());
        filterChainDefinition.addPathDefinition("/login.html", anon.name());
        filterChainDefinition.addPathDefinition("/login", anon.name());*/
        filterChainDefinition.addPathDefinition("/**", anon.name());
        return filterChainDefinition;
    }

}
