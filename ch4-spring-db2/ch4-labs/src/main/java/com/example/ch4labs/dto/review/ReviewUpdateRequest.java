package com.example.ch4labs.dto.review;

import com.example.ch4labs.domain.Review;

public class ReviewUpdateRequest {
    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private Integer rating;

    public ReviewResponse fromReq(Review review) {
        review.setTitle(title);
        review.setContent(content);
        review.setAuthor(author);
        review.setBookTitle(bookTitle);
        review.setBookAuthor(bookAuthor);
        review.setRating(rating);

        return ReviewResponse.from(review);
    }
}
