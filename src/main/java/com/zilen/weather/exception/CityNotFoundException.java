package com.zilen.weather.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CityNotFoundException extends RuntimeException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleCityIsNullException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "CITY NOT FOUND!", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
