package org.example.hellospringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.hellospringboot.model.UserRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@RequestMapping(path = "/api")
public class PutAPIController {
    @PutMapping("/put")
    public void put(
            @RequestBody UserRequest userRequest
            ){
        log.info("Request : {}", userRequest);
    }
}
