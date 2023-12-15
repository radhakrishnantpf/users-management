package com.sukri.users.management.exception.handler;

import com.sukri.users.management.enums.Common4XXExceptionEnum;
import com.sukri.users.management.enums.Common5XXExceptionEnum;
import com.sukri.users.management.exception.SearchFieldNotProvidedException;
import com.sukri.users.management.exception.UserNotFoundException;
import com.sukri.users.management.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException(UserNotFoundException userNotFoundException) {
        return userNotFoundException.getMessage();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(MissingServletRequestParameterException exception) {
        return new ErrorResponse(List.of(Common4XXExceptionEnum.INVALID_PARAMETER.getError(exception.getParameterName())));
    }

    @ExceptionHandler(SearchFieldNotProvidedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(SearchFieldNotProvidedException exception) {
        return new ErrorResponse(exception.getErrors());
    }


    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleException(NoResourceFoundException exception) {
        return new ErrorResponse(
                List.of(Common4XXExceptionEnum.RESOURCE_NOT_FOUND.getError(exception.getResourcePath())));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return new ErrorResponse(
                List.of(Common5XXExceptionEnum.INTERNAL_SERVER_ERROR.getError()));
    }

}
