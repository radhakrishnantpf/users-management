package com.sukri.users.management.exception;

import com.sukri.users.management.model.ErrorInfo;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseException {

    public UserNotFoundException(ErrorInfo errorInfo) {
        super(HttpStatus.NOT_FOUND, errorInfo);
    }
}
