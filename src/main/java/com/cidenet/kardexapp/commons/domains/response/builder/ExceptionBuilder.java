package com.cidenet.kardexapp.commons.domains.response.builder;


import com.cidenet.kardexapp.commons.exceptions.SystemException;
import org.springframework.http.HttpStatus;

public class ExceptionBuilder {
    private String message;
    private Throwable rootException;
    private HttpStatus httpStatus;

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
        this.httpStatus = httpStatus;
        return this;
    }


    public SystemException buildSystemException() {
        return new SystemException(message, rootException);
    }
}

