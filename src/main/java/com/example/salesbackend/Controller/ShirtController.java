package com.example.salesbackend.Controller;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.Clothes;
import com.example.salesbackend.Model.Shirt;
import com.example.salesbackend.Service.ShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shirt")
public class ShirtController {
    @Autowired
    private ShirtService shirtService;

    @GetMapping("/")
    public ApiResponse<Clothes> getShirtByNameType(@RequestParam("name") String name){
        return shirtService.getShirtByNameType(name);
    }

    @GetMapping("/all")
    public ApiResponse<List<Clothes>> getShirtByType(){
        return shirtService.getShirtByType();
    }

    @PostMapping
    public ApiResponse<Clothes> addShirt(@RequestBody Shirt shirt){
        return shirtService.addShirt(shirt);
    }

    @PutMapping("/{id}")
    public ApiResponse<Clothes> updateShirt(@PathVariable Long id, @RequestBody Shirt shirt) {
        return shirtService.updateShirt(id, shirt);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Clothes> deleteShirt(@PathVariable Long id) {
        return shirtService.deleteShirt(id);
    }
}
