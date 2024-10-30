package com.example.salesbackend.Service;

import com.example.salesbackend.Constants.HttpStatusCode;
import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.Inventory;
import com.example.salesbackend.Repository.InventoryRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepositoryInterface inventoryRepositoryInterface;

    public boolean checkInventory(Inventory inventory){
        return inventory.getInventoryClothesId()!=0 && inventory.getInventoryClothesId()!=0L &&
                inventory.getInventorySize()!=0 && inventory.getInventorySize()!=0L &&
                inventory.getInventoryColor()!=null && !inventory.getInventoryColor().isEmpty() &&
                inventory.getInventoryStock()!=0 && inventory.getInventoryStock()!=0L;
    }

    public ApiResponse<List<Inventory>> getAllInventory(){
        List<Inventory> inventoryList = inventoryRepositoryInterface.getAllInventory();
        if(inventoryList != null)
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), inventoryList);
        return new ApiResponse<>(HttpStatusCode.INVENTORY_NOT_FOUND.getCode(), HttpStatusCode.INVENTORY_NOT_FOUND.getMessage(), null);
    }

    public ApiResponse<Inventory> getInventoryById(Long id){
        Inventory inventory = inventoryRepositoryInterface.getInventoryById(id);
        if(inventory != null)
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), inventory);
        return new ApiResponse<>(HttpStatusCode.INVENTORY_NOT_FOUND.getCode(), HttpStatusCode.INVENTORY_NOT_FOUND.getMessage(),null);
    }

    public ApiResponse<Inventory> getInventoryByClothesId(Long id){
        Inventory inventoryClothesId = inventoryRepositoryInterface.getInventoryByClothesId(id);
        if(inventoryClothesId != null)
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), inventoryClothesId);
        return new ApiResponse<>(HttpStatusCode.INVENTORY_NOT_FOUND.getCode(), HttpStatusCode.INVENTORY_NOT_FOUND.getMessage(),null);
    }

    public ApiResponse<Inventory> addInventory(Inventory inventory){
        if(checkInventory(inventory)){
            inventoryRepositoryInterface.addInventory(inventory);
            return new ApiResponse<>(HttpStatusCode.ADD_SUCCESS.getCode(), HttpStatusCode.ADD_SUCCESS.getMessage(), inventory);
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), null);
    }

    public ApiResponse<Inventory> updateInventory(Long id, Inventory inventory){
        if(inventoryRepositoryInterface.getInventoryById(id)!=null && checkInventory(inventory)){
            inventoryRepositoryInterface.updateInventory(id, inventory);
            return new ApiResponse<>(HttpStatusCode.UPDATE_SUCCESS.getCode(), HttpStatusCode.UPDATE_SUCCESS.getMessage(), inventory);
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), null);
    }

    public ApiResponse<Inventory> deleteInventory(Long id){
        if(inventoryRepositoryInterface.getInventoryById(id)!=null){
            Inventory inventory = inventoryRepositoryInterface.getInventoryById(id);
            inventoryRepositoryInterface.deleteInventory(id);
            return new ApiResponse<>(HttpStatusCode.DELETE_SUCCESS.getCode(), HttpStatusCode.DELETE_SUCCESS.getMessage(), inventory);
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), null);
    }
}
