package com.sukri.users.management.enums;

import com.sukri.users.management.model.ErrorInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Common5XXExceptionEnum {
    INTERNAL_SERVER_ERROR(5001, "Internal Server Error", "Unexpected error occurred in the application");
    private int code;
    private String message;
    private String details;

    public ErrorInfo getError(){
        return new ErrorInfo(code, message, details);
    }
    public ErrorInfo getError(String fieldName){
        return new ErrorInfo(code, message, String.format(details, fieldName));
    }
}
