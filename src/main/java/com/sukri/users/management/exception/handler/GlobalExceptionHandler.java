package com.sukri.users.management.exception.handler;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.sukri.users.management.enums.Common4XXExceptionEnum;
import com.sukri.users.management.enums.Common5XXExceptionEnum;
import com.sukri.users.management.exception.BaseException;
import com.sukri.users.management.exception.UserNotFoundException;
import com.sukri.users.management.model.ErrorInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorInfo handleException(UserNotFoundException userNotFoundException) {
        return userNotFoundException.getError();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo handleException(MissingServletRequestParameterException exception) {
        return Common4XXExceptionEnum.INVALID_PARAMETER.getError(exception.getParameterName());
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorInfo> handleException(BaseException exception) {
        return new ResponseEntity<>(exception.getError(), exception.getHttpStatus());
    }


    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorInfo handleException(NoResourceFoundException exception) {
        return Common4XXExceptionEnum.RESOURCE_NOT_FOUND.getError(exception.getResourcePath());
    }

    @ExceptionHandler(MismatchedInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo handleException(MismatchedInputException exception) {
        log.error(exception.getMessage(), exception);
        return Common4XXExceptionEnum.INVALID_PAYLOAD.getError();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorInfo handleException(HttpRequestMethodNotSupportedException exception) {
        return Common4XXExceptionEnum.METHOD_NOT_FOUND.getError(exception.getMethod());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return Common5XXExceptionEnum.INTERNAL_SERVER_ERROR.getError();
    }

}
