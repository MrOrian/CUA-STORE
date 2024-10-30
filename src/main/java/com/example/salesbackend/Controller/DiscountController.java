package com.example.salesbackend.Controller;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.Discount;
import com.example.salesbackend.Service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @GetMapping("/{id}")
    public ApiResponse<Discount> getDiscountById(@PathVariable Long id) {
        return discountService.getDiscountById(id);
    }

    @GetMapping
    public ApiResponse<Discount> getDiscountByStatus(@RequestParam("status") String status) {
        return discountService.getDiscountByStatus(status);
    }

    @GetMapping("/all")
    public ApiResponse<List<Discount>> getAllDiscount() {
        return discountService.getAllDiscount();
    }

    @PostMapping
    public ApiResponse<Discount> addDiscount(@RequestBody Discount discount) {
        return discountService.addDiscount(discount);
    }

    @PutMapping("/{id}")
    public ApiResponse<Discount> updateDiscount(@PathVariable Long id, @RequestBody Discount discount) {
        return discountService.updateDiscount(id, discount);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Discount> updateDiscount(@PathVariable Long id) {
        return discountService.deleteDiscount(id);
    }

}