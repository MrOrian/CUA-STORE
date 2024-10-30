package com.example.salesbackend.Controller;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.Clothes;
import com.example.salesbackend.Service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothesController {
    @Autowired
    private ClothesService clothesService;

    @GetMapping("/all")
    public ApiResponse<List<Clothes>> getAllClothes(){
        return clothesService.getAllClothes();
    }

    @GetMapping("{name}")
    public ApiResponse<Clothes> getClothesByName(@PathVariable String name){
        return clothesService.getClothesByName(name);
    }

    @GetMapping("")
    public ApiResponse<List<Clothes>> getClothesByType(@RequestParam("type") String type){
        return clothesService.getClothesByType(type);
    }

    @PostMapping
    public ApiResponse<Clothes> addClothes(@RequestBody Clothes clothes){
        return clothesService.addClothes(clothes);
    }

    @PutMapping("/{id}")
    public ApiResponse<Clothes> updateClothes(@PathVariable Long id, @RequestBody Clothes clothes){
        return clothesService.updateClothes(id, clothes);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Clothes> deleteClothes(@PathVariable Long id){
        return clothesService.deleteClothes(id);
    }
}
