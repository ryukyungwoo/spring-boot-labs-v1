package com.example.ch2labs.labs03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumber {

    @GetMapping("/random")
    public ResponseNumber responseRandomNumber(@RequestParam int min, @RequestParam int max) {
        return new ResponseNumber(min, max);
    }
}
class ResponseNumber {
    int number;

    public ResponseNumber(int min, int max) {
        this.number = (int) ((Math.random() *(max - min)) + min );
    }

    public int getNumber() {
        return number;
    }
}