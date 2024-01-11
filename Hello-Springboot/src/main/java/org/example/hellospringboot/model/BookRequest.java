package org.example.hellospringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //전체 파라미터가 있는 생성자
@NoArgsConstructor //기본 생성자
public class BookRequest {
    private String name;
    private String number;
    private String category;
}
