package com.example.ch4labs.service;

import com.example.ch4labs.dto.review.*;
import com.example.ch4labs.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewResponse createReview(ReviewCreateRequest req) {
        return ReviewResponse.from(reviewRepository.save(req.toDomain()));
    }

//    @Transactional(readOnly = true)
//    public List<ReviewResponse> getAllReview(ReviewSearchRequest req) {
//
//        Pageable pageable = PageRequest.of(req.getPage(), req.getSize());
//
//        Page<Review> reviews;
//
//        if(req.getBookTitle() != null && req.getAuthor() != null && req.getMinRating() != null && req.getMaxRating() != null) {
//            reviews = reviewRepository.findByTitleContainingAndAuthorAndRatingBetween(req.getBookTitle(), req.getAuthor(), req.getMinRating(), req.getMaxRating(), pageable);
//        } else if(req.getBookTitle() != null) {
//            reviews = reviewRepository.findByTitleContaining(req.getBookTitle(),pageable);
//        } else if (req.getAuthor() != null && req.getRating() != null) {
//            reviews = reviewRepository.findByAuthorAndRating(req.getAuthor(), req.getRating(), pageable);
//        } else if (req.getMinRating() != null && req.getMaxRating() != null) {
//            reviews = reviewRepository.findReviewByRatingBetween(req.getMinRating(), req.getMaxRating(), pageable);
//        } else {
//            reviews = reviewRepository.findAll(pageable);
//        }
//
//        return reviews.stream().map(ReviewResponse::from).toList();
//    }

    @Transactional
    public ReviewQueryResponse getReviewBasedOnParameter(ReviewSearchRequest req) {
        return reviewRepository.search(req);
    }

    public ReviewResponse updateReview(Long id, ReviewUpdateRequest req) {
        return req.fromReq(reviewRepository.findById(id).orElseThrow());
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
