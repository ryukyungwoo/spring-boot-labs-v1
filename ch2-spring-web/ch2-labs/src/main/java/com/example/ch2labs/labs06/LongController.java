package com.example.ch2labs.labs06;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LongController {

    @PostMapping("/longest-word")
    public ResponseEntity<String> longestWord(@RequestBody Response response) {
        List<String> words = response.getWords();
        if (words == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not input");
        if(words.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not input");
        int longestWordIdx = 0;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() == Integer.MAX_VALUE) return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("long input");
            if(words.get(i).length() > words.get(longestWordIdx).length()) {
                longestWordIdx = i;
            }
        }
        return ResponseEntity.ok("가장 긴는 단어는 '" + words.get(longestWordIdx) + "'입니다.");
    }
}

@Getter
@AllArgsConstructor
class Response {
    List<String> words;
}