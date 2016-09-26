package com.example.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 9/9/16.
 */
@Configuration
@RequestMapping("/resource")
@EnableResourceServer
public class ResourceServer {

    @RequestMapping("/auth")
    String resourceOne() {
        return "This is resource 1. Congratulations, it's yours.";
    }
}
