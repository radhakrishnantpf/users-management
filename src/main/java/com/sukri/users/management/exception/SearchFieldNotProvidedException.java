package com.sukri.users.management.exception;

import com.sukri.users.management.model.ErrorInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchFieldNotProvidedException extends BaseException {
    public SearchFieldNotProvidedException(List<ErrorInfo> errors) {
        super(errors);
    }
}
