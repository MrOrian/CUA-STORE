package com.example.salesbackend.Service;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.Clothes;
import com.example.salesbackend.Model.Pants;
import com.example.salesbackend.Model.Shirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PantsService {
    @Autowired
    private ClothesService clothesService;

    public ApiResponse<Clothes> getPantsByNameType(String name){
        return clothesService.getClothesByNameType(name, "pants");
    }

    public ApiResponse<Clothes> addPants(Pants pants){
        return clothesService.addClothes(pants);
    }

    public ApiResponse<Clothes> updatePants(Long id, Pants pants){
        return  clothesService.updateClothes(id, pants);
    }

    public ApiResponse<Clothes> deletePants(Long id){
        return clothesService.deleteClothes(id);
    }

    public ApiResponse<List<Clothes>> getPantsByType(){
        return clothesService.getClothesByType("pants");
    }
}
