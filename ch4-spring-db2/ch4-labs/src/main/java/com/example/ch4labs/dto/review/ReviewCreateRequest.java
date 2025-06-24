package com.example.ch4labs.dto.review;

import com.example.ch4labs.domain.Review;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewCreateRequest {
    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private Integer rating;

    public Review toDomain() {
        return new Review(null, title, content, author, bookTitle, bookAuthor, rating, LocalDateTime.now(), null);
    }
}
