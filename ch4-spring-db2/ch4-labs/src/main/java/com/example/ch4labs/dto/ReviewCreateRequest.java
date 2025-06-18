package com.example.ch4labs.dto;

import com.example.ch4labs.domain.Review;

public class ReviewCreateRequest {
    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private Integer rating;

    public Review toDomain() {
        return new Review(null, title, content, author, bookTitle, bookAuthor, rating);
    }
}
