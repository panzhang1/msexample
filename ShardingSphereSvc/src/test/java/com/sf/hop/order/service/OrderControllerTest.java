package com.sf.hop.order.service;

import com.sf.hop.order.model.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.sf.hop.order.controller.OrderController;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"mysql"})
public class OrderControllerTest {

    @Autowired
    private OrderController orderService;

    @Test
    @Disabled
    public void testGetUser() {
        Order user = orderService.getOrder("admin");
        Assert.assertNotNull("Can get User from DB.", user);
    }
}
