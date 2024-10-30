package com.example.salesbackend.Repository;

import com.example.salesbackend.Model.Clothes;

import java.util.List;

public interface ClothesRepositoryInterface {
    void addClothes(Clothes clothes);
    void updateClothes(Clothes clothes, Long id);
    void deleteClothes(long id);
    Clothes getClothesById(Long id);
    Clothes getClothesByName(String name);
    List<Clothes> getClothesByType(String type);
    List<Clothes> getAllClothes();
}
