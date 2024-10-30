package com.example.salesbackend.Repository;

import com.example.salesbackend.Model.Discount;

import java.util.List;

public interface DiscountRepositoryInterface {
    void addDiscount(Discount discount);
    void updateDiscount(Long id, Discount discount);
    void deleteDiscount(long id);
    Discount getDiscountById(long id);
    Discount getDiscountByStatus(String status);
    List<Discount> getAllDiscounts();
}
