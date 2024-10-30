package com.example.salesbackend.Constants;

public enum HttpStatusCode {
    ADD_SUCCESS(200, "Added"),
    UPDATE_SUCCESS(200, "Updated"),
    DELETE_SUCCESS(200, "Deleted"),
    SUCCESS(200, "Success"),
    USER_NOT_FOUND(404,"User Not Found"),
    CLOTHES_NOT_FOUND(404,"Clothes Not Found"),

    INVENTORY_NOT_FOUND(404,"Inventory Not Found"),
    DISCOUNT_NOT_FOUND(404,"Discount Not Found"),
    DETAIL_ORDER_NOT_FOUND(404,"Detail Order Not Found"),
    ORDER_NOT_FOUND(404,"Orders Not Found"),
    USER_NAME_EXIT(404, "User Name Exited"),
    USER_EMAIL_EXIT(404, "User Email Exited"),
    CLOTHES_EXIT(404, "Clothes Exited"),
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error"),

    DATABASE_PROBLEM(299, "Data Wrong"),

    NO_ACTIVE(123, "User is not actived"),
    ACTIVED(124, "User actived"),
    WRONG_PASSWORD(125, "Password is wrong")
    ;

    private final int code;
    private final String message;

    HttpStatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
