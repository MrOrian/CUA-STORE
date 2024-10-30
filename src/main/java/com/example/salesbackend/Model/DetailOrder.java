package com.example.salesbackend.Model;

public class DetailOrder {
    private long id;
    private long detailOrderId;
    private long detailClothesId;
    private long detailOrderQuantity;
    private long detailOrderPrice;
    private long detailDiscountId;
    private long detailDiscountValue;

    public DetailOrder(long detailOrderId, long detailClothesId, long detailOrderQuantity, long detailOrderPrice, long detailDiscountId, long detailDiscountValue) {
        this.detailOrderId = detailOrderId;
        this.detailClothesId = detailClothesId;
        this.detailOrderQuantity = detailOrderQuantity;
        this.detailOrderPrice = detailOrderPrice;
        this.detailDiscountId = detailDiscountId;
        this.detailDiscountValue = detailDiscountValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDetailOrderId() {
        return detailOrderId;
    }

    public void setDetailOrderId(long detailOrderId) {
        this.detailOrderId = detailOrderId;
    }

    public long getDetailClothesId() {
        return detailClothesId;
    }

    public void setDetailClothesId(long detailClothesId) {
        this.detailClothesId = detailClothesId;
    }

    public long getDetailOrderQuantity() {
        return detailOrderQuantity;
    }

    public void setDetailOrderQuantity(long detailOrderQuantity) {
        this.detailOrderQuantity = detailOrderQuantity;
    }

    public long getDetailOrderPrice() {
        return detailOrderPrice;
    }

    public void setDetailOrderPrice(long detailOrderPrice) {
        this.detailOrderPrice = detailOrderPrice;
    }

    public long getDetailDiscountId() {
        return detailDiscountId;
    }

    public void setDetailDiscountId(long detailDiscountId) {
        this.detailDiscountId = detailDiscountId;
    }

    public long getDetailDiscountValue() {
        return detailDiscountValue;
    }

    public void setDetailDiscountValue(long detailDiscountValue) {
        this.detailDiscountValue = detailDiscountValue;
    }
}
