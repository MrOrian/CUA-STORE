package com.example.salesbackend.Repository;

import com.example.salesbackend.Model.Inventory;

import java.util.List;

public interface InventoryRepositoryInterface {
    void addInventory(Inventory inventory);
    void updateInventory(Long id, Inventory inventory);
    void deleteInventory(long id);
    Inventory getInventoryById(long id);
    Inventory getInventoryByClothesId(long id);
    List<Inventory> getAllInventory();
}
