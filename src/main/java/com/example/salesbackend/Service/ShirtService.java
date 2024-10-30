package com.example.salesbackend.Service;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.Clothes;
import com.example.salesbackend.Model.Shirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShirtService{
    @Autowired
    private ClothesService clothesService;

    public ApiResponse<Clothes> getShirtByNameType(String name){
        return clothesService.getClothesByNameType(name, "shirt");    }

    public ApiResponse<Clothes> addShirt(Shirt shirt){
        return clothesService.addClothes(shirt);
    }

    public ApiResponse<Clothes> updateShirt(Long id, Shirt shirt){
        return  clothesService.updateClothes(id, shirt);
    }

    public ApiResponse<Clothes> deleteShirt(Long id){
        return clothesService.deleteClothes(id);
    }

    public ApiResponse<List<Clothes>> getShirtByType(){
        return clothesService.getClothesByType("shirt");
    }
}
