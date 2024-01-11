package org.example.hellospringboot.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value=PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {
    private String name;
    private Integer userAge; //int를 사용하면 아무런 값이 없을 때 0으로 표현됨. Integer 사용하면 null
    private String email;
    private Boolean isKorean;

}
