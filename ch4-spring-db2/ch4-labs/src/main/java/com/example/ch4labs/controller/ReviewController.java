package com.example.ch4labs.controller;

import com.example.ch4labs.dto.review.*;
import com.example.ch4labs.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ReviewQueryResponse> read(@ModelAttribute ReviewSearchRequest req) {
//        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getAllReview(req));
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getReviewBasedOnParameter(req));
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
