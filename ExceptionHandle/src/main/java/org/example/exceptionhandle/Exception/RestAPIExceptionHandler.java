package org.example.exceptionhandle.Exception;

import lombok.extern.slf4j.Slf4j;
import org.example.exceptionhandle.Controller.ExceptionRestAPIBController;
import org.example.exceptionhandle.Controller.ExceptionRestAPIController;
import org.example.exceptionhandle.model.API;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(basePackageClasses = {ExceptionRestAPIBController.class, ExceptionRestAPIController.class}) //RestAPI가 사용하는 곳의 예외를 감지, 모든 예외를 잡아주는 글로벌한 컨트롤러 예외 핸들러
@Order(1)
public class RestAPIExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(Exception exception){
        log.error("RestAPIExceptionHandler", exception);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {IndexOutOfBoundsException.class}) //value에는 잡고 싶은 오류를 입력
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException exception
    ){
        log.error("IndexOutOfBoundsException", exception);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<API> noSuchElement(
            NoSuchElementException exception
    ){
        log.info("", exception);
        var reponse =  API.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(reponse);
    }

}
