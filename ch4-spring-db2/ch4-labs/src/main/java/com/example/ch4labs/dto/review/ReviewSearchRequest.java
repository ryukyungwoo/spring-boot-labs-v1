package com.example.ch4labs.dto.review;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewSearchRequest {
    private String author;
    private String bookTitle;
    private String bookTitleContains;
    private String bookAuthor;
    private String titleContains;
    private String contentContains;
    private String[] sort;
    private Integer rating;
    private Integer minRating;
    private Integer maxRating;
    private Integer page;
    private Integer size;
}
