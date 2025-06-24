package com.example.ch4labs.dto.comment;


import com.example.ch4labs.domain.Comment;
import com.example.ch4labs.domain.Review;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentCreateRequest {
    private String content;
    private String author;
    public Comment toDomain(Review review) {
        return Comment.builder()
                .review(review)
                .content(content)
                .author(author)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
