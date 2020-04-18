package com.cidenet.kardexapp.commons.exceptions;

import com.cidenet.kardexapp.commons.domains.response.builder.ResponseBuilder;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice()
public class BuilderExceptionHandler {

    @ExceptionHandler({SystemException.class})
    public ResponseEntity<?> systemException(SystemException e) {
        return ResponseBuilder.newBuilder()
                .withResponse("business exception")
                .withMessage(e.getMessage())
                .withStatus(HttpStatus.CONFLICT)
                .buildResponse();
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> exception(Exception e) {
        return ResponseBuilder.newBuilder()
                .withResponse("Generic system error")
                .withMessage(e.getMessage())
                .withStatus(HttpStatus.CONFLICT)
                .buildResponse();
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> notFound(NotFoundException e) {
        return ResponseBuilder.newBuilder()
                .withResponse("System error, not found")
                .withMessage(e.getMessage())
                .withStatus(HttpStatus.NOT_FOUND)
                .buildResponse();
    }
}
