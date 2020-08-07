package com.ecommerce_website.shop_api.exception;

public class CustomException extends Exception{

    private String message;
    private Integer statusCode;

    public CustomException(String message,Integer statusCode){
        super();
        this.message=message;
        this.statusCode=statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
