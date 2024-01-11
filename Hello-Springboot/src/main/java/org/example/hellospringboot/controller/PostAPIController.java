package org.example.hellospringboot.controller;

import org.example.hellospringboot.model.BookRequest;
import org.example.hellospringboot.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class PostAPIController {
    @PostMapping("/post")
    public String post(
            //default로 객체를 받아야함. Json, Spring boot web은 json이 default
            @RequestBody BookRequest bookRequest //post,put방식에서 바디로 들어오는 데이터를 해당 객체에 맵핑해주겠다.

            ){
        System.out.println(bookRequest);
        return bookRequest.toString();
    }
    //localhost:8080/api/user
    @PostMapping("/user")
    public UserRequest user(
            @RequestBody UserRequest userRequest
            ){
        System.out.println(userRequest);
        return userRequest;
    }
}
