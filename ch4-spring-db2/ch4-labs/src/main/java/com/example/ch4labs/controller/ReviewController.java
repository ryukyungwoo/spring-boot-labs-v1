package com.example.ch4labs.controller;

import com.example.ch4labs.dto.ReviewCreateRequest;
import com.example.ch4labs.dto.ReviewResponse;
import com.example.ch4labs.dto.ReviewUpdateRequest;
import com.example.ch4labs.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponse> create(@RequestBody ReviewCreateRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.createReview(req));
    }
    @GetMapping
    public ResponseEntity<List<ReviewResponse>> read() {
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getAllReview());
    }
    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponse> update(@PathVariable Long id, @RequestBody ReviewUpdateRequest req) {
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.updateReview(id, req));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
