package org.example.hellospringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.example.hellospringboot.model.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController //응답 값이 json으로 내려가겠다.
//@RequestMapping("/api/vi")
public class ReponseAPIController {

    @GetMapping("")//-> http://localhost:8080/user/vi 디폴트로 지정
    public ResponseEntity<UserRequest> user(){
        var user = new UserRequest();
        user.setName("홍길동");
        user.setUserAge(20);
        user.setEmail("hong@gmail.com");

        log.info("user : {}",user);
//원하는 HttpStatusCode의 값을 나타내고 싶을 때 ReponseEntity를 사용한다.
        var reponse = ResponseEntity
                .status(HttpStatus.OK)
                .header("x-customs", "hi")
                .body(user);
        return reponse;
    }
}
