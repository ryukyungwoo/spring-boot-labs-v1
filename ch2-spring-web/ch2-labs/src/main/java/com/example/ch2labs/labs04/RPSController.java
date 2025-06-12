package com.example.ch2labs.labs04;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RPSController {

    @GetMapping("/rps")
    public Game rpsGame(@RequestParam String user) {
        return new Game(user);
    }
}
class Game {
    String user;
    String server;
    String result;

    public String getUser() {
        return user;
    }

    public String getServer() {
        return server;
    }

    public String getResult() {
        return result;
    }

    public Game(String user) {
        this.user = user;
        int serverRPS = (int) (Math.random() * 3);
        System.out.println(serverRPS);
        if (serverRPS == 0) {
            this.server = "rock";
        } else if (serverRPS == 1) {
            this.server = "scissors";
        } else {
            this.server = "paper";
        }
        if(user.equals("rock")) {
            if(server.equals("scissors")) {
                this.result = "You Win!";
            } else if (server.equals("paper")) {
                this.result = "You Lose!";
            } else {
                this.result = "Draw";
            }
        } else if(user.equals("scissors")) {
            if(server.equals("paper")) {
                this.result = "You Win!";
            } else if (server .equals("rock") ) {
                this.result = "You Lose!";
            } else {
                this.result = "Draw";
            }
        } else {
            if(server.equals("rock")) {
                this.result = "You Win!";
            } else if (server.equals("scissors")) {
                this.result = "You Lose!";
            } else {
                this.result = "Draw";
            }
        }

    }
}