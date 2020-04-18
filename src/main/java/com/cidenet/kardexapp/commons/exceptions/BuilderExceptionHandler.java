package com.cidenet.kardexapp.commons.exceptions;

import com.cidenet.kardexapp.commons.domains.response.builder.ExceptionBuilder;
import com.cidenet.kardexapp.commons.enums.TransactionState;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice()
public class BuilderExceptionHandler {

    @ExceptionHandler({SystemException.class})
    public SystemException systemException(SystemException e) {
        return ExceptionBuilder.newBuilder()
                .withMessage(e.getMessage())
                .withRootException(e)
                .withHttpStatus(HttpStatus.CONFLICT)
                .withTransactionState(TransactionState.FAIL)
                .buildSystemException();
    }

    @ExceptionHandler({Exception.class})
    public SystemException exception(Exception e) {
        return ExceptionBuilder.newBuilder()
                .withMessage(e.getMessage())
                .withRootException(e)
                .withHttpStatus(HttpStatus.CONFLICT)
                .withTransactionState(TransactionState.FAIL)
                .buildSystemException();

    }

    @ExceptionHandler({NotFoundException.class})
    public SystemException notFound(NotFoundException e) {
        return ExceptionBuilder.newBuilder()
                .withMessage(e.getMessage())
                .withRootException(e)
                .withHttpStatus(HttpStatus.NOT_FOUND)
                .withTransactionState(TransactionState.FAIL)
                .buildSystemException();
    }
}
