package com.sukri.users.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;
@AllArgsConstructor
@Data
public class ErrorResponse {
    private List<ErrorInfo> errors;
}
