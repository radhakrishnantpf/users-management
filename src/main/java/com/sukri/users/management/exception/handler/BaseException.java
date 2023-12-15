package com.sukri.users.management.exception.handler;

public abstract class BaseException extends RuntimeException {
    private int code;
    private String message;
    private String description;
}