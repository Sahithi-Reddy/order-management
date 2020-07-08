package com.dbs.order.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class FeignExceptionHandler {

    @ExceptionHandler(FeignException.BadRequest.class)  
    public ResponseEntity<CustomErrorResponse> handleFeignStatusException(FeignException e, HttpServletResponse response) {
        CustomErrorResponse error = new CustomErrorResponse("BAD_REQUEST_ERROR", e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FeignException.NotFound.class)  
    public ResponseEntity<CustomErrorResponse> handleFeignNotFoundException(FeignException e, HttpServletResponse response) {
        CustomErrorResponse error = new CustomErrorResponse("NOT_FOUND_ERROR", e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus((HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
