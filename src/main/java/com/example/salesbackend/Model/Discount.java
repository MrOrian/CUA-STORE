package com.example.salesbackend.Model;

import java.util.Date;

public class Discount {
    private long id;
    private String discountCode;
    private long discountValue;
    private long discountClothesId;
    private long discountMinOrder;
    private Date discountDateStart;
    private Date discountDateEnd;
    private String discountStatus;

    public Discount(String discountCode, long discountValue, long discountClothesId, long discountMinOrder, Date discountDateStart, Date discountDateEnd, String discountStatus) {
        this.discountCode = discountCode;
        this.discountValue = discountValue;
        this.discountClothesId = discountClothesId;
        this.discountMinOrder = discountMinOrder;
        this.discountDateStart = discountDateStart;
        this.discountDateEnd = discountDateEnd;
        this.discountStatus = discountStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public long getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(long discountValue) {
        this.discountValue = discountValue;
    }

    public long getDiscountClothesId() {
        return discountClothesId;
    }

    public void setDiscountClothesId(long discountClothesId) {
        this.discountClothesId = discountClothesId;
    }

    public long getDiscountMinOrder() {
        return discountMinOrder;
    }

    public void setDiscountMinOrder(long discountMinOrder) {
        this.discountMinOrder = discountMinOrder;
    }

    public Date getDiscountDateStart() {
        return discountDateStart;
    }

    public void setDiscountDateStart(Date discountDateStart) {
        this.discountDateStart = discountDateStart;
    }

    public Date getDiscountDateEnd() {
        return discountDateEnd;
    }

    public void setDiscountDateEnd(Date discountDateEnd) {
        this.discountDateEnd = discountDateEnd;
    }

    public String getDiscountStatus() {
        return discountStatus;
    }

    public void setDiscountStatus(String discountStatus) {
        this.discountStatus = discountStatus;
    }
}
