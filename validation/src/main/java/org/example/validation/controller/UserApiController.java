package org.example.validation.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.validation.model.Api;
import org.example.validation.model.UserRegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public Api<UserRegisterRequest> register(

        @Valid
        @RequestBody
        Api<UserRegisterRequest> userRegisterRequest
    ){
        log.info("init: {}", userRegisterRequest);
        var body = userRegisterRequest.getData();
        return Api.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();
    }
}
