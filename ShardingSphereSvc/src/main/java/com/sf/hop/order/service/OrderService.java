package com.sf.hop.order.service;

import com.sf.hop.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.hop.order.dao.OrderDAO;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDao;
    
    public Order getOrder(int orderId) {
        return orderDao.getOrder(orderId);
    }

    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }
}
