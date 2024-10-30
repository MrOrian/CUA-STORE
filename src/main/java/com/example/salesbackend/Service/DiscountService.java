package com.example.salesbackend.Service;

import com.example.salesbackend.Constants.HttpStatusCode;
import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.Discount;
import com.example.salesbackend.Repository.DiscountRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    @Autowired
    private DiscountRepositoryInterface discountRepositoryInterface;

    public boolean checkDiscount(Discount discount){
        return discount.getDiscountCode()!=null && !discount.getDiscountCode().isEmpty() &&
                discount.getDiscountValue()!=0 && discount.getDiscountValue()!=0L &&
                discount.getDiscountClothesId()!=0 && discount.getDiscountClothesId()!=0L &&
                discount.getDiscountMinOrder()!=0L &&
                discount.getDiscountDateStart()!=null &&
                discount.getDiscountDateEnd()!=null &&
                discount.getDiscountStatus()!=null & !discount.getDiscountStatus().isEmpty();
    }

    public ApiResponse<Discount> getDiscountById(Long id){
        Discount newDiscount = discountRepositoryInterface.getDiscountById(id);
        if(newDiscount != null)
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), newDiscount);
        return new ApiResponse<>(HttpStatusCode.DISCOUNT_NOT_FOUND.getCode(), HttpStatusCode.DISCOUNT_NOT_FOUND.getMessage(), null);
    }

    public ApiResponse<Discount> getDiscountByStatus(String status){
        Discount newDiscount = discountRepositoryInterface.getDiscountByStatus(status);
        if(newDiscount != null)
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), newDiscount);
        return new ApiResponse<>(HttpStatusCode.DISCOUNT_NOT_FOUND.getCode(), HttpStatusCode.DISCOUNT_NOT_FOUND.getMessage(), null);
    }

    public ApiResponse<List<Discount>> getAllDiscount(){
        List<Discount> discountList = discountRepositoryInterface.getAllDiscounts();
        if(discountList != null)
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), discountList);
        return new ApiResponse<>(HttpStatusCode.DISCOUNT_NOT_FOUND.getCode(), HttpStatusCode.DISCOUNT_NOT_FOUND.getMessage(), null);
    }

    public ApiResponse<Discount> addDiscount(Discount discount){
        if(checkDiscount(discount)) {
            discountRepositoryInterface.addDiscount(discount);
            return new ApiResponse<>(HttpStatusCode.ADD_SUCCESS.getCode(), HttpStatusCode.ADD_SUCCESS.getMessage(), discount);
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), null);
    }

    public ApiResponse<Discount> updateDiscount(Long id, Discount discount){
        if(discountRepositoryInterface.getDiscountById(id)!= null && checkDiscount(discount) ) {
            discountRepositoryInterface.updateDiscount(id, discount);
            return new ApiResponse<>(HttpStatusCode.UPDATE_SUCCESS.getCode(), HttpStatusCode.UPDATE_SUCCESS.getMessage(), discount);
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), null);
    }

    public ApiResponse<Discount> deleteDiscount(Long id){
        if(discountRepositoryInterface.getDiscountById(id)!= null ) {
            Discount discount = discountRepositoryInterface.getDiscountById(id);
            discountRepositoryInterface.deleteDiscount(id);
            return new ApiResponse<>(HttpStatusCode.DELETE_SUCCESS.getCode(), HttpStatusCode.DELETE_SUCCESS.getMessage(), discount);
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), null);
    }
}
