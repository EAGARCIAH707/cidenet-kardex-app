package com.cidenet.kardexapp.commons.domains.response.builder;


import com.cidenet.kardexapp.commons.enums.TransactionState;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionBuilder {
    private String message;
    private Throwable rootException;
    TransactionState state;

    private ExceptionBuilder() {
    }

    public static ExceptionBuilder newBuilder() {
        return new ExceptionBuilder();
    }

    public ExceptionBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public ExceptionBuilder withRootException(Throwable rootException) {
        this.rootException = rootException;
        return this;
    }

    public ExceptionBuilder withHttpStatus(HttpStatus httpStatus) {
        return this;
    }

    public ExceptionBuilder withTransactionState(TransactionState state) {
        LocalDateTime timeResponse = LocalDateTime.now();
        this.state = state;
        return this;
    }


    public SystemException buildSystemException() {
        return new SystemException(message, rootException);
    }
}

