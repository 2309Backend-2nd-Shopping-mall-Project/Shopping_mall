package com.github.shopping_mall.shopping_mall_project.service.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
