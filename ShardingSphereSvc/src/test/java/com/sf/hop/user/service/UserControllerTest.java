package com.sf.hop.user.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.sf.hop.user.controller.UserController;
import com.sf.hop.user.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"hana"})
public class UserControllerTest {

    @Autowired
    private UserController userService;

    @Test
    @Disabled
    public void testGetUser() {
        User user = userService.getUser("admin");
        Assert.assertNotNull("Can get User from DB.", user);
    }
}
