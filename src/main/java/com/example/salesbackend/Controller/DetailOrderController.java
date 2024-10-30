package com.example.salesbackend.Controller;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.DetailOrder;
import com.example.salesbackend.Service.DetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detail-order")
public class DetailOrderController {
    @Autowired
    private DetailOrderService detailOrderService;

    @GetMapping
    public ApiResponse<DetailOrder> getDetailOrderByOrderId(@RequestParam("order-id") Long id) {
        return detailOrderService.getDetailOrderByOrderId(id);
    }

    @GetMapping("/{id}")
    public ApiResponse<DetailOrder> getDetailOrderByStatus(Long id) {
        return detailOrderService.getDetailOrderById(id);
    }

    @GetMapping("/all")
    public ApiResponse<List<DetailOrder>> getAllDetailOrder() {
        return detailOrderService.getAllDetailOrder();
    }

    @PostMapping
    public ApiResponse<DetailOrder> addDetailOrder(@RequestBody DetailOrder DetailOrder) {
        return detailOrderService.addDetailOrder(DetailOrder);
    }

    @PutMapping("/{id}")
    public ApiResponse<DetailOrder> updateDetailOrder(@PathVariable Long id, @RequestBody DetailOrder DetailOrder) {
        return detailOrderService.updateDetailOrder(id, DetailOrder);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<DetailOrder> updateDetailOrder(@PathVariable Long id) {
        return detailOrderService.deleteDetailOrder(id);
    }

}
