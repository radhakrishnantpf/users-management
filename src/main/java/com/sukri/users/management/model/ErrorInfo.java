package com.sukri.users.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorInfo {
    private int code;
    private String message;
    private String details;
}
