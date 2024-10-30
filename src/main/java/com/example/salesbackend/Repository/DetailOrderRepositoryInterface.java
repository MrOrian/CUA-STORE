package com.example.salesbackend.Repository;

import com.example.salesbackend.Model.DetailOrder;

import java.util.List;

public interface DetailOrderRepositoryInterface {
    void addDetailOrder(DetailOrder detailOrder);
    void updateDetailOrder(Long id, DetailOrder detailOrder);
    void deleteDetailOrder(long id);
    DetailOrder getDetailOrderById(long id);
    DetailOrder getDetailOrderByOrderId(long id);
    List<DetailOrder> getAllDetailOrders();
}
