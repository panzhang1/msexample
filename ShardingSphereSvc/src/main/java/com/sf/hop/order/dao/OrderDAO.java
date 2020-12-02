package com.sf.hop.order.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sf.hop.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Order getOrder(int userId) {
        String querySql = String.format("SELECT order_id, user_id, order_desc FROM t_order WHERE order_id = ?");

        List<Order> users = jdbcTemplate.query( querySql, new Object[] { userId },new OrderMapper());
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    public List<Order> getAllOrders() {
        String querySql = "SELECT order_id, user_id, order_desc FROM t_order";

        List<Order> orders = jdbcTemplate.query( querySql,new OrderMapper());
        return orders;
    }
    
    class OrderMapper implements RowMapper<Order> {

        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setUserId(rs.getInt("user_id"));
            order.setOrderId(rs.getInt("order_id"));
            order.setOrderDesc(rs.getString("order_desc"));
            return order;
        }
        
    }
}
