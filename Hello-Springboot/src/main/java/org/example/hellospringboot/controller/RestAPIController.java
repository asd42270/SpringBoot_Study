package org.example.hellospringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.hellospringboot.model.BookQueryParam;
import org.example.hellospringboot.model.SumMul;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController//restapi처리하는 컨트롤러 지정
//@RequestMapping("/api")//api로 시작하는 주소의 요청은 여기서 처리
public class RestAPIController {
    //클라이언트가 특정 요청을 보내주기 위해 서버의 진입점이 어떠한 주소를 가지는 지를 작성
    //어떠한 주소를 받겠다를 설정
    //응답을 내려줬고, 문자열로 전달을 했다. 0 또는 1이라는 비트 단위의 데이터로 전달한다.
    @GetMapping(path = "/hello")//hello라는 주소는 이 메소드가 처리하겠다.
    public  String hello(){
        var html = "<html> <body> <h1> Hello Spring-Boot </h1> </body> </html>";
        return html;
    }
    // {age}, {isMan}에 받는 값들 입력
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}") //pathvariable에서 메세지와 값이 다르면 안됨->(name = "message")를 통해 해결
    public String echo(
            @PathVariable(name = "message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){ //메세지에 해당하는 값들을 문자로 파싱

        System.out.println("echo message: "+msg);
        System.out.println("echo message: "+age);
        System.out.println("echo message: "+isMan);//서버에서 어떻게 전송되는지 보여줌
        // "http:
        // TODO 대문자로 변환해서 RETURN
        return msg.toUpperCase();
    }
    //쿼리 파라미터 파싱
    //쿼리 파라미터 http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(
            //request 파라미터로 들어오는 것을 매칭시키겠다.
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam (name="issued-month") String issuedMonth,
            @RequestParam String issued_day//snake케이스는 추천하지 않는다.
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issued_day);

    }

    //http://localhost:8080/api/book2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
    //query-parameter에 한해서는 카멜 케이스로 쓰겠다.
    @GetMapping(path = "/book2") //주소와 변수의 값을 일치 시켜주어야 한다.
    public void queryParamDto(
            //request 파라미터로 들어오는 것을 매칭시키겠다.
            BookQueryParam bookQueryParam //아무런 어노테이션을 붙이지 않는다.
    ){
        System.out.println(bookQueryParam);

    }
    //TODO 파라미터를 두 가지로 받는다. int로 받아서 두 수의 덧셈을 해주는 주소를 설계, 이를 쿼리파라미터로 넘기면
    //TODO 의 곱셉을 리턴해주는 메소드와 곱셈을 리턴해주는 메소드 두 가지를 작성해서 쿼리파라미터를 파싱
    //TODO String과 Boolean 타입도 받아보기
    //http://localhost:8080/api/number?a=5&b=5&sum
    @GetMapping(path = "/number")
    public String querySum(
            SumMul sumMul
    ){
       String mul = String.valueOf(sumMul.mul());
       String sum =  String.valueOf(sumMul.sum());

       return "덧셈은"+sum+" 곱셉은"+mul ;
    }

    @DeleteMapping(path = {"/user/{userName}/delete",
            "/user/{userName}/del"})
    public void delete(
        @PathVariable String userName
    ){
        log.info("user-name: {}", userName);
    }
}
