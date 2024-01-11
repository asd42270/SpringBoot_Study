package org.example.hellospringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //전체 데이터가 들어간 기본 생성자
public class BookQueryParam {
    String category;
    String issuedYear;
    String issuedMonth;
    String issuedDay;
}
