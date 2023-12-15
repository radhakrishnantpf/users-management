package com.sukri.users.management.exception;

import com.sukri.users.management.model.ErrorInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class BaseException extends RuntimeException {
    private List<ErrorInfo> errors;

    BaseException(List<ErrorInfo> errors) {
        this.errors = errors;
    }
}