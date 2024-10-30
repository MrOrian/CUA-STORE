package com.example.salesbackend.Model;

public class Inventory {
    private long id;
    private long inventoryClothesId;
    private int inventorySize;
    private String inventoryColor;
    private long inventoryStock;


    public Inventory(Long id, long inventoryClothesId, int inventorySize, String inventoryColor, long inventoryStock) {
        this.id = id;
        this.inventoryClothesId = inventoryClothesId;
        this.inventorySize = inventorySize;
        this.inventoryColor = inventoryColor;
        this.inventoryStock = inventoryStock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInventoryClothesId() {
        return inventoryClothesId;
    }

    public void setInventoryClothesId(long inventoryClothesId) {
        this.inventoryClothesId = inventoryClothesId;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }

    public String getInventoryColor() {
        return inventoryColor;
    }

    public void setInventoryColor(String inventoryColor) {
        this.inventoryColor = inventoryColor;
    }

    public long getInventoryStock() {
        return inventoryStock;
    }

    public void setInventoryStock(long inventoryStock) {
        this.inventoryStock = inventoryStock;
    }
}
