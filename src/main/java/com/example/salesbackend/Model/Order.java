package com.example.salesbackend.Model;

import java.time.LocalDate;

public class Order {
    private long id;
    private long orderUserId;
    private LocalDate orderDate;
    private long orderTotalPrice;
    private String orderStatus;
    private String orderPaymentMethod;
    private String orderPaymentStatus;
    private String orderShippingAddress;
    private long orderShippingCost;

    public Order() {
    }

    public Order(long orderUserId, LocalDate orderDate,long orderTotalPrice, String orderStatus, String orderPaymentMethod, String orderPaymentStatus, String orderShippingAddress, long orderShippingCost) {
        this.orderUserId = orderUserId;
        this.orderDate = orderDate;
        this.orderTotalPrice = orderTotalPrice;
        this.orderStatus = orderStatus;
        this.orderPaymentMethod = orderPaymentMethod;
        this.orderPaymentStatus = orderPaymentStatus;
        this.orderShippingAddress = orderShippingAddress;
        this.orderShippingCost = orderShippingCost;
    }

    public Order(long id, long orderUserId, LocalDate orderDate,long orderTotalPrice, String orderStatus, String orderPaymentMethod, String orderPaymentStatus, String orderShippingAddress, long orderShippingCost) {
        this.id = id;
        this.orderUserId = orderUserId;
        this.orderDate = orderDate;
        this.orderTotalPrice = orderTotalPrice;
        this.orderStatus = orderStatus;
        this.orderPaymentMethod = orderPaymentMethod;
        this.orderPaymentStatus = orderPaymentStatus;
        this.orderShippingAddress = orderShippingAddress;
        this.orderShippingCost = orderShippingCost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(long orderUserId) {
        this.orderUserId = orderUserId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public long getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(long orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderPaymentMethod() {
        return orderPaymentMethod;
    }

    public void setOrderPaymentMethod(String orderPaymentMethod) {
        this.orderPaymentMethod = orderPaymentMethod;
    }

    public String getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    public void setOrderPaymentStatus(String orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    public String getOrderShippingAddress() {
        return orderShippingAddress;
    }

    public void setOrderShippingAddress(String orderShippingAddress) {
        this.orderShippingAddress = orderShippingAddress;
    }

    public long getOrderShippingCost() {
        return orderShippingCost;
    }

    public void setOrderShippingCost(long orderShippingCost) {
        this.orderShippingCost = orderShippingCost;
    }
}
