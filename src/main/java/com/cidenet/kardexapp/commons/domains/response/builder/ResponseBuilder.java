package com.cidenet.kardexapp.commons.domains.response.builder;


import com.cidenet.kardexapp.commons.domains.response.BaseResponse;
import com.cidenet.kardexapp.commons.enums.TransactionState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;

public class ResponseBuilder<T> {

    private T response;
    private HttpStatus httpStatus;
    private LocalDateTime timeResponse;
    private String path;
    private String message;
    private TransactionState state;
    MultiValueMap<String, String> header = new LinkedMultiValueMap<>();

    private ResponseBuilder() {
    }

    public static ResponseBuilder newBuilder() {
        return new ResponseBuilder();
    }

    public ResponseBuilder withResponse(T response) {
        this.response = response;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseBuilder withPath(String path) {
        this.path = path;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseBuilder withStatus(HttpStatus status) {
        this.httpStatus = status;
        return this;
    }

    public ResponseBuilder withMessage(String message) {
        this.message = message;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseBuilder withTransactionState(TransactionState state) {
        this.state = state;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseBuilder withHeader(String key, String value) {
        this.header.add(key, value);
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseEntity<BaseResponse<T>> buildResponse() {
        BaseResponse<T> base = new BaseResponse<>(this.response, this.httpStatus, this.timeResponse, this.message,
                this.path, this.state);
        return new ResponseEntity<BaseResponse<T>>(base, this.header, this.httpStatus);
    }
}
