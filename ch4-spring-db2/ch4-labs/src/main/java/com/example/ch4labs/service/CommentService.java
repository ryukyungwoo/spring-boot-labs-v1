package com.example.ch4labs.service;

import com.example.ch4labs.domain.Comment;
import com.example.ch4labs.dto.comment.CommentCreateRequest;
import com.example.ch4labs.dto.comment.CommentResponse;
import com.example.ch4labs.dto.comment.CommentUpdateRequest;
import com.example.ch4labs.repository.CommentRepository;
import com.example.ch4labs.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ReviewRepository reviewRepository;

    public CommentResponse createComment(Long reviewId, CommentCreateRequest request) {
        return CommentResponse.from(commentRepository.save(request.toDomain(reviewRepository.findById(reviewId).orElseThrow(() -> new EntityNotFoundException("no")))));
    }

    public CommentResponse updateComment(Long commentId, CommentUpdateRequest request) {
        Comment foundComment = commentRepository.findById(commentId).orElseThrow(() -> new EntityNotFoundException("no"));
        foundComment.setContent(request.getContent());
        foundComment.setUpdateAt(LocalDateTime.now());
        return CommentResponse.from(foundComment);
    }

    public void deleteComment(Long commentId) {

    }
}
