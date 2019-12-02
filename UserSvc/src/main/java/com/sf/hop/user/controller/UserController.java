package com.sf.hop.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sf.hop.PlatformJwtProperties;
import com.sf.hop.ServiceConfig;
import com.sf.hop.user.model.User;
import com.sf.hop.user.service.UserService;

@RestController
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    private ServiceConfig serviceConfig;
    
    @Value("${platform.jwt.key}")
    private String jwtKey;
    
    @Autowired
    private PlatformJwtProperties jwtProperties;
    
    @GetMapping(value = "/user/{userId}")
    public User getUser(@PathVariable(value="userId") String userId) {
        User user = userService.getUser(userId);
        LOG.info(String.format("-----------getUser:%s", user.toString()));
        return user;
    }
    
    @GetMapping(value = "/version")
    public String getVersion() {
        StringBuilder sb = new StringBuilder();
        sb.append("platform.jwt.key:").append(jwtKey).append("\n");
        sb.append("platform.jwt.key_from PlatformJwtProperties:").append(jwtProperties.getKey()).append("\n");
        sb.append("application_feature1:").append(serviceConfig.getAppFeature1()).append("\n");
        sb.append("application_env_feature1:").append(serviceConfig.getAppEnvFeature1()).append("\n");
        sb.append("service_feature1:").append(serviceConfig.getServiceFeature1()).append("\n");
        sb.append("service_env_feature1:").append(serviceConfig.getServiceEnvFeature1());
       
        return sb.toString();
    }
}