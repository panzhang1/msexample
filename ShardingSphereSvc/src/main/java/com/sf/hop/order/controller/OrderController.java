package com.sf.hop.order.controller;

import com.sf.hop.order.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sf.hop.order.service.OrderService;

import java.util.List;

@RestController
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    
    @GetMapping(value = "/order/{orderId}")
    public Order getOrder(@PathVariable(value="orderId") String orderId) {
        return orderService.getOrder(Integer.parseInt(orderId));
    }

    @GetMapping(value = "/order/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}