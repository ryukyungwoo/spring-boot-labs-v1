package com.example.ch4labs.dto.review;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ReviewQueryResponse {
    private List<ReviewResponse> content;
    private Integer totalElements;
    private Integer totalPages;
    private Integer size;
    private Integer page;
}
