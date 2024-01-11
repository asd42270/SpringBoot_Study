package org.example.hellospringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SumMul {
    int a;
    int b;
    int sum;

    public int sum(){
        sum = a+b;
        return sum;
    }

    public int mul(){
        return a*b;
    }
}
