package com.example.ch4labs.dto.review;

import com.example.ch4labs.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private Integer rating;

    public static ReviewResponse from(Review save) {
        return new ReviewResponse(save.getId(), save.getTitle(), save.getContent(), save.getAuthor(), save.getBookTitle(), save.getBookTitle(), save.getRating());
    }
}
