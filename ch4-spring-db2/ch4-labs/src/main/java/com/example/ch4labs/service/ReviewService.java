package com.example.ch4labs.service;

import com.example.ch4labs.dto.ReviewCreateRequest;
import com.example.ch4labs.dto.ReviewResponse;
import com.example.ch4labs.dto.ReviewUpdateRequest;
import com.example.ch4labs.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewResponse createReview(ReviewCreateRequest req) {
        return ReviewResponse.from(reviewRepository.save(req.toDomain()));
    }

    @Transactional(readOnly = true)
    public List<ReviewResponse> getAllReview() {
        return reviewRepository.findAll().stream().map(ReviewResponse::from).toList();
    }

    public ReviewResponse updateReview(Long id, ReviewUpdateRequest req) {
        return req.fromReq(reviewRepository.findById(id).orElseThrow());
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
