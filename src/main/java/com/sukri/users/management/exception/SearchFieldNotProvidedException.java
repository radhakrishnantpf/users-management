package com.sukri.users.management.exception;

import com.sukri.users.management.model.ErrorInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class SearchFieldNotProvidedException extends BaseException {
    public SearchFieldNotProvidedException(ErrorInfo error) {
        super(HttpStatus.BAD_REQUEST, error);
    }
}
