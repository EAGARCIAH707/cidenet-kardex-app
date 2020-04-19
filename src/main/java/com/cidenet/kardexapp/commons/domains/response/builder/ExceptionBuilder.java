package com.cidenet.kardexapp.commons.domains.response.builder;


import com.cidenet.kardexapp.commons.domains.response.BaseResponse;
import com.cidenet.kardexapp.commons.enums.TransactionState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ExceptionBuilder<T> {
    private String message;
    private TransactionState state;
    private T response;
    private HttpStatus httpStatus;
    private LocalDateTime timeResponse;


    private ExceptionBuilder() {
    }

    public static ExceptionBuilder newBuilder() {
        return new ExceptionBuilder();
    }

    public ExceptionBuilder<T> withMessage(String message) {
        this.message = message;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ExceptionBuilder<T> withRootException(T rootException) {
        this.response = rootException;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ExceptionBuilder<T> withHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ExceptionBuilder<T> withTransactionState(TransactionState state) {
        this.state = state;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseEntity<?> buildSystemException() {
        BaseResponse<T> base = new BaseResponse<T>(this.response, this.httpStatus, this.timeResponse, this.message,
                this.state);
        return new ResponseEntity<>(base, this.httpStatus);
    }
}

