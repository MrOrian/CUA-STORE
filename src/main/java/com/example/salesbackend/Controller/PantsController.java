package com.example.salesbackend.Controller;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.Clothes;
import com.example.salesbackend.Model.Pants;
import com.example.salesbackend.Service.PantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pants")
public class PantsController {
    @Autowired
    private PantsService pantsService;

    @GetMapping("/")
    public ApiResponse<Clothes> getPantsByNameType(@RequestParam("name") String name){
        return pantsService.getPantsByNameType(name);
    }

    @GetMapping("/all")
    public ApiResponse<List<Clothes>> getPantsByType(){
        return pantsService.getPantsByType();
    }

    @PostMapping
    public ApiResponse<Clothes> addPants(@RequestBody Pants pants){
        return pantsService.addPants(pants);
    }

    @PutMapping("/{id}")
    public ApiResponse<Clothes> updatePants(@PathVariable Long id, @RequestBody Pants pants) {
        return pantsService.updatePants(id, pants);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Clothes> deletePants(@PathVariable Long id) {
        return pantsService.deletePants(id);
    }
}
