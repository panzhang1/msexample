package com.sf.hop.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sf.hop.user.model.User;
import com.sf.hop.user.service.UserService;

@RestController
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    
    @GetMapping(value = "/user/{userId}")
    public User getUser(@PathVariable(value="userId") String userId) {
        User user = userService.getUser(userId);
        LOG.info(String.format("-----------getUser:%s", user.toString()));
        return user;
    }
}