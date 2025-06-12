package com.captainyun7.ch2codeyourself._01_basic_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class BasicController {

    // GET /basic/hello 요청이 왔을 때, hello 매서드 실행
    @GetMapping("/basic/hello")
    @ResponseBody // HTTP  Body에 담기
    public String hello() {
        return "hello";
    }

    // userId가 동적인 값 {경로 변수}
    @GetMapping("/basic/users/{userId}")
    @ResponseBody
    public String users(@PathVariable int userId) {
        return "user id :" + userId;
    }

    @GetMapping("/basic/users/{userId}/orders/{orderId}")
    @ResponseBody
    public String userOrder(@PathVariable int userId, @PathVariable int orderId) {
        return "user Id:" + userId + ", order Id: " + orderId;
    }

    // /basic/params?name=1&age=2
    // RequestParam은 생략 가능
    @ResponseBody
    @GetMapping("/basic/params")
    public String params(@RequestParam String name,@RequestParam int age) {
        return "name: " + name + ", age: " + age;
    }

    @ResponseBody
    @GetMapping("/basic/filter")
    public String filter(@RequestParam Map<String, String> params) {
        return "all parameters: " + params.toString() ;
    }

    @PostMapping("/basic/users")
    @ResponseBody
    public String post () {
        return "user sign in success";
    }

    @PutMapping("/basic/users/{userId}") // 하나 수정
    @ResponseBody
    public String put(@PathVariable String userId) {
        return "user modify success";
    }

    @DeleteMapping("/basic/users/{userId}")
    @ResponseBody
    public String delete (@PathVariable String userId) {
        return "user delete in fail";
    }
}
