package com.example.ch2labs.labs02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomDice {

    @GetMapping("/dice")
    public Dice randomDice() {
        Dice dice = new Dice();
        return dice;
    }
}

class Dice {
    int dice;

    public int getDice() {
        return dice;
    }

    public Dice () {
        this.dice = (int) ((Math.random()*5) +1);
    }
}