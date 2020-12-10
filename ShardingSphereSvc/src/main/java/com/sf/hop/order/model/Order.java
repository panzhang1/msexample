package com.sf.hop.order.model;

public class Order {
    private int orderId;
    private int userId;
    private String orderDesc;

    public Order() {
    }

    public Order(int orderId, int userId, String orderDesc) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDesc = orderDesc;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", orderDesc='" + orderDesc + '\'' +
                '}';
    }
}
