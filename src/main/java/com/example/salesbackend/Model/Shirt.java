package com.example.salesbackend.Model;

public class Shirt extends Clothes{
    public Shirt() {
    }

    public Shirt(String clothesName, String clothesType, Long clothesPrice, String clothesBrand, String clothesImage, String clothesDescription, String clothesStatus) {
        super(clothesName, "shirt", clothesPrice, clothesBrand, clothesImage, clothesDescription, clothesStatus);
    }
}
