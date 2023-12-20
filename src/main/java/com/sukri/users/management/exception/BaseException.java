package com.sukri.users.management.exception;

import com.sukri.users.management.model.ErrorInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException {
    private HttpStatus httpStatus;
    private ErrorInfo error;
}