package org.example.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.validation.annotation.PhoneNumber;
import org.example.validation.annotation.YearMonth;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // 2023-01-01T13:00:00 - yyyy-MM-ddTHH:mm:ss
        // 202301만 볼 것
        // size를 통해서 size가 6인가
        var revalue = value+"01";
        var repattern = pattern+"dd";
        try{
            LocalDate date = LocalDate.parse(revalue, DateTimeFormatter.ofPattern(repattern));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
