package com.example.salesbackend.Model;

public class Pants extends Clothes{

    public Pants() {
    }

    public Pants(String clothesName, String clothesType, Long clothesPrice, String clothesBrand, String clothesImage, String clothesDescription, String clothesStatus) {
        super(clothesName, "pants", clothesPrice, clothesBrand, clothesImage, clothesDescription, clothesStatus);
    }
}
