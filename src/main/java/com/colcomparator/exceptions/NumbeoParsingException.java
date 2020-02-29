package com.colcomparator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumbeoParsingException extends Exception {
    public NumbeoParsingException(String message) {
    super(message);
    }
}
