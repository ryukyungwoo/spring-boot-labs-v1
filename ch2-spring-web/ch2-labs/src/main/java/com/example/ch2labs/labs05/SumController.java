package com.example.ch2labs.labs05;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class SumController {

    @GetMapping("/sum-digits")
    public ResponseEntity<String> sumDigit(@RequestParam String number) {
        try {
            String[] splitNum = number.split("");

            if (splitNum[0].equals("-")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("음수는 지원하지 않습니다. 양의 정수를 입력해주세요.");
            }

            if (Arrays.stream(splitNum).toList().contains(".")) {
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("정수만 입력 가능합니다. 예: /sum-digits?number=1234");
            }

            int sum = 0;

            for (String num : splitNum) {
                int nowNum = Integer.parseInt(num);
                sum += nowNum;
            }

            return ResponseEntity.status(HttpStatus.OK).body("각 자리수 합: " + sum);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("정수만 입력 가능합니다. 예: /sum-digits?number=1234");
        }
    }
}
