package com.example.ch2labs.labs01;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Calculator {

    @GetMapping("/calc")
    public String calc (@RequestParam Map<String, String> input) {

        int x = Integer.parseInt(input.get("x"));
        int y = Integer.parseInt(input.get("y"));
        String calc = input.get("op");

        String result;

        switch (calc) {
            case "add" -> result = "result: x + y = " + (x + y);
            case "sub" -> result = "result: x - y = " + (x - y);
            case "mul" -> result = "result: x * y = " + (x * y);
            case "div" -> result = "result: x / y = " + (x / y);
            default -> result = "resurrect operation";
        }

        return result;
    }
}
