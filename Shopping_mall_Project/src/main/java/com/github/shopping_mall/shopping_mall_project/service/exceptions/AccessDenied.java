package com.github.shopping_mall.shopping_mall_project.service.exceptions;

public class AccessDenied extends RuntimeException {

    public AccessDenied(String message) {
        super(message);
    }
}
