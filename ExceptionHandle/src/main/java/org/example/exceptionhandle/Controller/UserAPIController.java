package org.example.exceptionhandle.Controller;

import org.example.exceptionhandle.model.API;
import org.example.exceptionhandle.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(("/api/user") )
public class UserAPIController {
    private static List<UserResponse> userList = List.of(
            UserResponse.builder() //빌더를 통해 체이닝된 방식으로 사용
                    .userId("1")
                    .userName("홍길동")
                    .userAge(20)
                    .build(),
            UserResponse.builder()
                    .userId("2")
                    .userName("유관순")
                    .userAge(24)
                    .build()
    );
    @GetMapping("/id/{userId}")
    public API<UserResponse> getUser(
            @PathVariable String userId
    ){
        if(true){
            throw new RuntimeException("message");
        }

        var user = userList.stream().
                filter(it -> it.getUserId().equals(userId))
                .findFirst()
                .get();

        API<UserResponse> userResponse = API.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(user)
                .build();
        return userResponse;
    }
}
