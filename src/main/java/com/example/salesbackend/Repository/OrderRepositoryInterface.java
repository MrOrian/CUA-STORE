package com.example.salesbackend.Repository;


import com.example.salesbackend.Model.Order;

import java.util.List;

public interface OrderRepositoryInterface {
    void addOrder(Order order);
    void updateOrder(Long id, Order order);
    void deleteOrder(long id);
    Order getOrderById(long id);
    List<Order> getAllOrders();
    List<Order> getOrdersByUserId(Long id);
}
