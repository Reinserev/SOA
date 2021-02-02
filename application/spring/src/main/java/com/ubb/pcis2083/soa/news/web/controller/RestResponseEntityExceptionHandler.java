package com.ubb.pcis2083.soa.news.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger log = LogManager.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        log.warn("handleConflict: ex={}", ex);
        log.warn("Details: " + ex.toString());
        log.warn(Arrays.toString(ex.getStackTrace()));

        if (ex.getCause() != null)
            try {
                if (ex.getCause().getCause() instanceof BindException) {
                    return handleBindException((BindException) (ex.getCause().getCause()), request);
                }
            } catch (Exception e) {
                log.warn("handleConflict - exception occurred (expecting NPE or CCE) - IGNORE: e={}", e);
            }

        ApiError apiError = new ApiError(HttpStatus.CONFLICT, ex.getLocalizedMessage(), ex.toString());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    private ResponseEntity<Object> handleBindException(BindException ex, WebRequest request) {
        log.warn("BindException occured, lol");
        log.warn("handleBindException: ex={}", ex);
        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex.getAllErrors().toString());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("handleMethodArgumentNotValid: ex={}", ex);
        log.warn(Arrays.toString(ex.getStackTrace()));

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,
                ex.getLocalizedMessage(), ex.getBindingResult().toString());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

}

class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    ApiError(HttpStatus status, String message, String error) {
        this(status, message, Collections.singletonList(error));
    }
}
