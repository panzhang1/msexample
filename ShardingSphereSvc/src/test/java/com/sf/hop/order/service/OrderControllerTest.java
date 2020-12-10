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

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderControllerTest.class);
    @Autowired
    private OrderController orderController;

    private Order buildOrder(int orderId, int userId, String orderDesc) {
        Order order = new Order(orderId, userId, orderDesc);
        return order;
    }

    @Test
    public void addOrders() {
        List<Order> orders = new ArrayList<>();
        Order order = buildOrder(20001,99991, "20001_99991");
        orders.add(order);

        order = buildOrder(20002,99991, "20002_99991");
        orders.add(order);

        order = buildOrder(20003,99992, "20003_99992");
        orders.add(order);

        order = buildOrder(20004,99992, "20004_99992");
        orders.add(order);

        for(Order orderItem : orders) {
            orderController.addOrder(order);
        }
    }

    @Test
    public void getOrder() {
        Order order = orderController.getOrder("10000");
        LOGGER.info(order.toString());
    }

    @Test
    public void getAllOrders() {
        List<Order> orders = orderController.getAllOrders();
        StringBuilder sb = new StringBuilder();
        for(Order order : orders) {
            sb.append("\n").append(order.toString());
        }
        LOGGER.info(sb.toString());
    }
}
