package com.sukri.users.management.enums;

import com.sukri.users.management.exception.BaseException;
import com.sukri.users.management.model.ErrorInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum Common4XXExceptionEnum {

    INVALID_PARAMETER(4001, "Invalid parameter value", "The provided value for field %s is missing or invalid"),
    FIRST_NAME_OR_LAST_NAME_NOT_PROVIDED(4002, "Invalid parameter value", "field %s is required for search with firstName and lastName"),
    RESOURCE_NOT_FOUND(4003, "Resource Not Found", "Resource: /%s is not available, please check the resource you have tried"),
    USER_NOT_FOUND(4004, "User Not Found", "Unable to find the user"),
    INVALID_PAYLOAD(4005, "Invalid PayLoad Data", "Invalid payload data received as input" ),
    INVALID_PATH_PARAMETER(4006, "Invalid Path Parameter value", "The provided value for field %s is missing or invalid"),
    INVALID_EMP_ID(4007, "Invalid EmpId ", "EmpId provided in the Path Variable is invalid, it should be numeric"),
    METHOD_NOT_FOUND(4008, "Invalid Http Method", "Requested method %s is not supported");

    private int code;
    private String message;
    private String details;

    public ErrorInfo getError() {
        return new ErrorInfo(code, message, details);
    }

    public ErrorInfo getError(String fieldName) {
        return new ErrorInfo(code, message, String.format(details, fieldName));
    }

    public BaseException getException() {
        return new BaseException(HttpStatus.BAD_REQUEST, getError());
    }
    public BaseException getException(String fieldName) {
        return new BaseException(HttpStatus.BAD_REQUEST, getError(fieldName));
    }

}
