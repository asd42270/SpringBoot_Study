package org.example.exceptionhandle.Exception;

import lombok.extern.slf4j.Slf4j;
import org.example.exceptionhandle.model.API;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice

public class GlobalExceptionHandler {
    //예측하지 못한 모든 예외를 야기서 처리하겠다.

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<API> exception(
            Exception e
    ){
        log.error("", e);
        var response = API.builder()
                .resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .resultMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
