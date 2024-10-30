package com.example.salesbackend.Service;

import com.example.salesbackend.Constants.HttpStatusCode;
import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.DetailOrder;
import com.example.salesbackend.Model.DetailOrder;
import com.example.salesbackend.Repository.DetailOrderRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailOrderService {
    @Autowired
    private DetailOrderRepositoryInterface detailOrderRepositoryInterface;
    
    public boolean checkDetailOrder(DetailOrder detailOrder){
        return detailOrder.getDetailOrderId()!=0L && detailOrder.getDetailOrderId()!=0 &&
                detailOrder.getDetailClothesId()!=0L && detailOrder.getDetailClothesId()!=0 &&
                detailOrder.getDetailOrderPrice()!=0L &&
                detailOrder.getDetailOrderQuantity()!=0L && detailOrder.getDetailOrderQuantity()!=0;
    }

    public ApiResponse<DetailOrder> getDetailOrderById(Long id){
        DetailOrder newDetailOrder = detailOrderRepositoryInterface.getDetailOrderById(id);
        if(newDetailOrder != null)
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), newDetailOrder);
        return new ApiResponse<>(HttpStatusCode.DETAIL_ORDER_NOT_FOUND.getCode(), HttpStatusCode.DETAIL_ORDER_NOT_FOUND.getMessage(), null);
    }

    public ApiResponse<DetailOrder> getDetailOrderByOrderId(Long id){
        DetailOrder newDetailOrder = detailOrderRepositoryInterface.getDetailOrderByOrderId(id);
        if(newDetailOrder != null)
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), newDetailOrder);
        return new ApiResponse<>(HttpStatusCode.DETAIL_ORDER_NOT_FOUND.getCode(), HttpStatusCode.DETAIL_ORDER_NOT_FOUND.getMessage(), null);
    }

    public ApiResponse<List<DetailOrder>> getAllDetailOrder(){
        List<DetailOrder> detailOrderList = detailOrderRepositoryInterface.getAllDetailOrders();
        if(detailOrderList != null)
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), detailOrderList);
        return new ApiResponse<>(HttpStatusCode.DETAIL_ORDER_NOT_FOUND.getCode(), HttpStatusCode.DETAIL_ORDER_NOT_FOUND.getMessage(), null);
    }

    public ApiResponse<DetailOrder> addDetailOrder(DetailOrder DetailOrder){
        if(checkDetailOrder(DetailOrder)) {
            detailOrderRepositoryInterface.addDetailOrder(DetailOrder);
            return new ApiResponse<>(HttpStatusCode.ADD_SUCCESS.getCode(), HttpStatusCode.ADD_SUCCESS.getMessage(), DetailOrder);
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), null);
    }

    public ApiResponse<DetailOrder> updateDetailOrder(Long id, DetailOrder DetailOrder){
        if(detailOrderRepositoryInterface.getDetailOrderById(id)!= null && checkDetailOrder(DetailOrder) ) {
            detailOrderRepositoryInterface.updateDetailOrder(id, DetailOrder);
            return new ApiResponse<>(HttpStatusCode.UPDATE_SUCCESS.getCode(), HttpStatusCode.UPDATE_SUCCESS.getMessage(), DetailOrder);
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), null);
    }

    public ApiResponse<DetailOrder> deleteDetailOrder(Long id){
        if(detailOrderRepositoryInterface.getDetailOrderById(id)!= null ) {
            DetailOrder detailOrder = detailOrderRepositoryInterface.getDetailOrderById(id);
            detailOrderRepositoryInterface.deleteDetailOrder(id);
            return new ApiResponse<>(HttpStatusCode.DELETE_SUCCESS.getCode(), HttpStatusCode.DELETE_SUCCESS.getMessage(), detailOrder);
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), null);
    }
}
