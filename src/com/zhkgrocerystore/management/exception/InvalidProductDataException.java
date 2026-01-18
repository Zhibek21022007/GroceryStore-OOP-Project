package com.zhkgrocerystore.management.exception;

public class InvalidProductDataException extends IllegalArgumentException {
    public InvalidProductDataException(String message) {
        super(message);
    }
}
