package com.example.salesbackend.Controller;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.Order;
import com.example.salesbackend.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public ApiResponse<List<Order>> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ApiResponse<Order> getOrderById(@PathVariable Long id) {
        return  orderService.getOrderById(id);
    }

    @GetMapping
    public ApiResponse<List<Order>> getOrderByUserId(@RequestParam("user-id") Long id) {
        return orderService.getOrderByUserId(id);
    }

    @PostMapping
    public ApiResponse<Order> addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }

    @PutMapping("/{id}")
    public ApiResponse<Order> updateOrder(@PathVariable Long id, @RequestBody Order order){
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteOrder(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }

}