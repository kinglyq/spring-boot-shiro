package com.github.kinglyq.springbootshiro.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @PostMapping("login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam LoginForm loginForm) {

        log.info("username: {}", loginForm.getUsername());
        log.info("password: {}", loginForm.getPassword());

        Map<String, Object> map = new HashMap<>(16);
        map.put("error", 0);

        return ResponseEntity.ok(map);
    }

}

@Getter
@Setter
class LoginForm {
    private String username;
    private String password;
}