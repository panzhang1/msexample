package com.sf.hop.order.service;

import com.sf.hop.order.model.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.sf.hop.order.controller.OrderController;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderControllerTest.class);
    @Autowired
    private OrderController orderController;

    @Test
    public void getOrder() {
        Order order = orderController.getOrder("10000");
        LOGGER.info(order.toString());
    }

    @Test
    public void getAllOrders() {
        List<Order> orders = orderController.getAllOrders();
        LOGGER.info(orders.toString());
    }
}
