package org.example.exceptionhandle.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping(path = "/api/b")
public class ExceptionRestAPIBController {

    @GetMapping("/hello")
    public void hello(){
        throw new NumberFormatException("Number format exception");
    }
    //컨트롤러 내에서 예외 처리를 하고 없으면 Advice로 간다.
/*    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity numberFormatException(
            NumberFormatException numberFormatException
    ){
        log.error("RestAPIBController: {}", numberFormatException);
        return ResponseEntity.ok().build();
    }*/
}
