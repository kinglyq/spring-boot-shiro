package com.github.kinglyq.springbootshiro.security;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author kinglyq
 */
@Configuration
public class ShiroConfig {

    @Resource
    private RepoRealm repoRealm;

    @Bean
    public SecurityManager securityManager() {
        return new DefaultWebSecurityManager();
    }

    @Bean
    public Realm realm() {
        return repoRealm;
    }

    @Bean
    protected CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition filterChainDefinition = new DefaultShiroFilterChainDefinition();
        filterChainDefinition.addPathDefinition("/assets/**", "anon");
        filterChainDefinition.addPathDefinition("/login", "anon");
        filterChainDefinition.addPathDefinition("/**", "authc");
        return filterChainDefinition;
    }

}
