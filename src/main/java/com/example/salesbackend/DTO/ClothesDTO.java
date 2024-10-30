package com.example.salesbackend.DTO;

public class ClothesDTO {
    private long id;
    private String clothesName;
    private String clothesType;
    private Long clothesPrice;
    private String clothesBrand;
    private String clothesImage;
    private String clothesDescription;
    private String clothesStatus;



    public ClothesDTO(long id, String clothesName, String clothesType, Long clothesPrice, String clothesBrand, String clothesImage, String clothesDescription, String clothesStatus) {
        this.id = id;
        this.clothesName = clothesName;
        this.clothesType = clothesType;
        this.clothesPrice = clothesPrice;
        this.clothesBrand = clothesBrand;
        this.clothesImage = clothesImage;
        this.clothesDescription = clothesDescription;
        this.clothesStatus = clothesStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public String getClothesType() {
        return clothesType;
    }

    public void setClothesType(String clothesType) {
        this.clothesType = clothesType;
    }

    public long getClothesPrice() {
        return clothesPrice;
    }

    public void setClothesPrice(long clothesPrice) {
        this.clothesPrice = clothesPrice;
    }

    public String getClothesBrand() {
        return clothesBrand;
    }

    public void setClothesBrand(String clothesBrand) {
        this.clothesBrand = clothesBrand;
    }

    public String getClothesImage() {
        return clothesImage;
    }

    public void setClothesImage(String clothesImage) {
        this.clothesImage = clothesImage;
    }

    public String getClothesDescription() {
        return clothesDescription;
    }

    public void setClothesDescription(String clothesDescription) {
        this.clothesDescription = clothesDescription;
    }

    public String getClothesStatus() {
        return clothesStatus;
    }

    public void setClothesStatus(String clothesStatus) {
        this.clothesStatus = clothesStatus;
    }
}
