package com.example.salesbackend.Service;

import com.example.salesbackend.Constants.HttpStatusCode;
import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.Clothes;
import com.example.salesbackend.Model.Clothes;
import com.example.salesbackend.Repository.ClothesRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService {
    @Autowired
    private ClothesRepositoryInterface clothesRepositoryInterface;
    
    public ApiResponse<List<Clothes>> getAllClothes(){
        return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), clothesRepositoryInterface.getAllClothes());
    }

    public ApiResponse<Clothes> getClothesByName(String name){
        Clothes newClothes = clothesRepositoryInterface.getClothesByName(name);
        if(newClothes != null && !newClothes.getClothesName().isEmpty()){
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), newClothes);
        }
        return new ApiResponse<>(HttpStatusCode.CLOTHES_NOT_FOUND.getCode(), HttpStatusCode.CLOTHES_NOT_FOUND.getMessage(), newClothes);
    }

    public ApiResponse<Clothes> getClothesByNameType(String name, String type){
        Clothes newClothes = clothesRepositoryInterface.getClothesByName(name);
        if(newClothes != null && !newClothes.getClothesName().isEmpty() && newClothes.getClothesType().equals(type)){
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), newClothes);
        }
        return new ApiResponse<>(HttpStatusCode.CLOTHES_NOT_FOUND.getCode(), HttpStatusCode.CLOTHES_NOT_FOUND.getMessage(), newClothes);
    }

    public ApiResponse<List<Clothes>> getClothesByType(String type){
        System.out.println(type);
        List<Clothes> newClothes = clothesRepositoryInterface.getClothesByType(type);
        if(newClothes != null){
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), newClothes);
        }
        return new ApiResponse<>(HttpStatusCode.CLOTHES_NOT_FOUND.getCode(), HttpStatusCode.CLOTHES_NOT_FOUND.getMessage(), newClothes);
    }
    
    public ApiResponse<Clothes> addClothes(Clothes clothes){
        if(clothes != null) {
            if(clothesRepositoryInterface.getClothesByName(clothes.getClothesName()) != null)
                return new ApiResponse<>(HttpStatusCode.CLOTHES_EXIT.getCode(), HttpStatusCode.CLOTHES_EXIT.getMessage(), clothes);
            else{
                clothesRepositoryInterface.addClothes(clothes);
                return new ApiResponse<>(HttpStatusCode.ADD_SUCCESS.getCode(), HttpStatusCode.ADD_SUCCESS.getMessage(), clothes);
            }
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), clothes);
    }

    public ApiResponse<Clothes> updateClothes(Long id, Clothes clothes){
        if(clothes != null) {
            if(clothesRepositoryInterface.getClothesById(id) != null){
                clothesRepositoryInterface.updateClothes(clothes, id);
                return new ApiResponse<>(HttpStatusCode.UPDATE_SUCCESS.getCode(), HttpStatusCode.UPDATE_SUCCESS.getMessage(), clothes);
            }
            return new ApiResponse<>(HttpStatusCode.CLOTHES_NOT_FOUND.getCode(), HttpStatusCode.USER_NOT_FOUND.getMessage(), clothes);
        }
        return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), clothes);
    }

    public ApiResponse<Clothes> deleteClothes(Long id){
            Clothes clothes = clothesRepositoryInterface.getClothesById(id);
            if(clothesRepositoryInterface.getClothesById(id) != null){
                clothesRepositoryInterface.deleteClothes(id);
                return new ApiResponse<>(HttpStatusCode.UPDATE_SUCCESS.getCode(), HttpStatusCode.UPDATE_SUCCESS.getMessage(), clothes);
            }
            return new ApiResponse<>(HttpStatusCode.CLOTHES_NOT_FOUND.getCode(), HttpStatusCode.USER_NOT_FOUND.getMessage(), clothes);
    }
}
