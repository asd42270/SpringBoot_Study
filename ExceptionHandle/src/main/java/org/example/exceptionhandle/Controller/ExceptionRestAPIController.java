package org.example.exceptionhandle.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api")
public class ExceptionRestAPIController {
    @GetMapping(path = "")
    public void exception(){
        var list = List.of("hello");

        var element = list.get(1);

        log.info("element: {}", element);
    }
}