package com.sf.hop.order.controller;

import com.sf.hop.order.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sf.hop.order.service.OrderService;

@RestController
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    
    @GetMapping(value = "/order/{orderId}")
    public Order getOrder(@PathVariable(value="orderId") String orderId) {
        Order order = orderService.getOrder(orderId);
        LOG.info(String.format("-----------getOrder:%s", order.toString()));
        return order;
    }
}