package com.example.salesbackend.Service;


import com.example.salesbackend.Constants.HttpStatusCode;
import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.Order;
import com.example.salesbackend.Repository.OrderRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepositoryInterface orderRepositoryInterface;

    public boolean checkOrder(Order order){
        return order.getOrderUserId() != 0 && order.getOrderUserId()!=0L &&
                order.getOrderDate() != null &&
                order.getOrderTotalPrice() != 0 && order.getOrderTotalPrice()!= 0L &&
                order.getOrderStatus()!= null && !order.getOrderStatus().isEmpty() &&
                order.getOrderPaymentMethod()!= null && !order.getOrderPaymentMethod().isEmpty() &&
                order.getOrderPaymentStatus()!= null && !order.getOrderPaymentStatus().isEmpty() &&
                order.getOrderShippingAddress()!= null && !order.getOrderShippingAddress().isEmpty() &&
                order.getOrderShippingCost()!= 0L;
    }

    public ApiResponse<List<Order>> getAllOrders(){
        List<Order> orderList = orderRepositoryInterface.getAllOrders();
        if(orderList != null){
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), orderList);
        } else {
            return new ApiResponse<>(HttpStatusCode.ORDER_NOT_FOUND.getCode(), HttpStatusCode.ORDER_NOT_FOUND.getMessage(), null);
        }
    }

    public ApiResponse<Order> getOrderById(Long id){
        Order newOrder = orderRepositoryInterface.getOrderById(id);
        if(newOrder != null){
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), newOrder);
        } else{
            return new ApiResponse<>(HttpStatusCode.ORDER_NOT_FOUND.getCode(), HttpStatusCode.ORDER_NOT_FOUND.getMessage(), newOrder);
        }
    }

    public ApiResponse<List<Order>> getOrderByUserId(Long id){
        List<Order> orderList = orderRepositoryInterface.getOrdersByUserId(id);
        if(orderList != null){
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), orderList);
        } else{
            return new ApiResponse<>(HttpStatusCode.ORDER_NOT_FOUND.getCode(), HttpStatusCode.ORDER_NOT_FOUND.getMessage(), orderList);
        }
    }

    public ApiResponse<Order> addOrder(Order order){
        if(checkOrder(order)){
            orderRepositoryInterface.addOrder(order);
            return new ApiResponse<>(HttpStatusCode.ADD_SUCCESS.getCode(), HttpStatusCode.ADD_SUCCESS.getMessage(), order);
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), order);
    }

    public ApiResponse<Order> updateOrder(Long id, Order order){
        if(checkOrder(order)) {
            orderRepositoryInterface.updateOrder(id, order);
            return new ApiResponse<>(HttpStatusCode.UPDATE_SUCCESS.getCode(), HttpStatusCode.UPDATE_SUCCESS.getMessage(), order);
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), order);
    }

    public ApiResponse<String> deleteOrder(Long id){
        if(getOrderById(id)!=null){
            orderRepositoryInterface.deleteOrder(id);
            return new ApiResponse<>(HttpStatusCode.DELETE_SUCCESS.getCode(), HttpStatusCode.DELETE_SUCCESS.getMessage(), "Order by id = "+id+" has been deleted");
        }
        return new ApiResponse<>(HttpStatusCode.ORDER_NOT_FOUND.getCode(), HttpStatusCode.ORDER_NOT_FOUND.getMessage(), null);
    }

    }
