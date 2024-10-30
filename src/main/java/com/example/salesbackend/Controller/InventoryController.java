package com.example.salesbackend.Controller;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.Model.Inventory;
import com.example.salesbackend.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/all")
    public ApiResponse<List<Inventory>> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("{id}")
    public ApiResponse<Inventory> getInventoryById(Long id) {
        return inventoryService.getInventoryById(id);
    }

    @GetMapping
    public ApiResponse<Inventory> getInventoryByClothesId(@RequestParam("clothes") Long id) {
        return inventoryService.getInventoryByClothesId(id);
    }

    @PostMapping()
    public ApiResponse<Inventory> addInventory(@RequestBody Inventory inventory){
        return inventoryService.addInventory(inventory);
    }

    @PutMapping("/{id}")
    public ApiResponse<Inventory> updateInventory(@PathVariable Long id, @RequestBody Inventory inventory){
        return inventoryService.updateInventory(id, inventory);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Inventory> deleteInventory(@PathVariable Long id){
        return inventoryService.deleteInventory(id);
    }

}