package com.example.ch4labs.dto.comment;

import com.example.ch4labs.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Builder
@AllArgsConstructor
public class CommentResponse {
    private Long id;
    private String content;
    private String author;
    private Long reviewId;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public static CommentResponse from(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .author(comment.getAuthor())
                .reviewId(comment.getReview().getId())
                .createdAt(comment.getCreatedAt())
                .updateAt(comment.getUpdateAt())
                .build();
    }
}
