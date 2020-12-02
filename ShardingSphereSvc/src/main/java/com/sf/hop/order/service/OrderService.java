package com.sf.hop.order.service;

import com.sf.hop.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.hop.order.dao.OrderDAO;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDao;
    
    public Order getOrder(String orderId) {
        return orderDao.getOrder(orderId);
    }
}
