//package com.example.ch4labs.service;
//
//import com.example.ch4labs.domain.Review;
//import com.example.ch4labs.dto.review.ReviewSearchRequest;
//import com.example.ch4labs.repository.ReviewRepository;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.when;
//
//@Disabled
//@ExtendWith(MockitoExtension.class)
//class ReviewServiceTest {
//
//    @Mock
//    ReviewRepository reviewRepository;
//    @InjectMocks
//    ReviewService reviewService;
//
//    @Test
//    void getAllReview() {
//
//        // given
//        ReviewSearchRequest req = new ReviewSearchRequest("bookTitle", "author", 5, 1,5,0,10);
//        Pageable pageable = PageRequest.of(req.getPage(), req.getSize());
//
//        // when
//        Page<Review> reviews = null;
//        when(reviewRepository.findByTitleContainingAndAuthorAndRatingBetween(req.getBookTitle(), req.getAuthor(), req.getMinRating(), req.getMaxRating(), pageable))
//                .thenReturn(reviews);
//
//        // then
//        assertThat(reviews.getContent().size()).isEqualTo(10);
//    }
//}