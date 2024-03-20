package com.example.Calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Parameter;

@RestController
public class CalculatorController {
    @GetMapping("/home")
    public String home(){
        return "Welcome to the my calculator application.";
    }

    @GetMapping("/add")
    public double addition(@RequestParam double n1, @RequestParam double n2){
        return n1+n2;
    }

    @GetMapping("/sub")
    public double subtraction(@RequestParam double n1, @RequestParam double n2){
        return n1-n2;
    }

    @GetMapping("/mul")
    public double multiplication(@RequestParam double n1, @RequestParam double n2){
        return n1*n2;
    }

    @GetMapping("/div")
    public double division(double n1, double n2){
        if(n2==0){
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return n1/n2;
    }
}
