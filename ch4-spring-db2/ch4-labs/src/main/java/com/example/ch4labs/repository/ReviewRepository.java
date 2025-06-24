package com.example.ch4labs.repository;

import com.example.ch4labs.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryRepository {

    Page<Review> findByAuthorAndRating(String author, Integer rating, Pageable pageable);

    Page<Review> findReviewByRatingBetween(Integer minRating, Integer maxRating, Pageable pageable);

    Page<Review> findByTitleContainingAndAuthorAndRatingBetween(String bookTitle, String author, Integer minRating, Integer maxRating, Pageable pageable);

    Page<Review> findByTitleContaining(String bookTitle, Pageable pageable);
}
