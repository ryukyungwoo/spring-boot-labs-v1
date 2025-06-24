package com.example.ch4labs.repository;

import com.example.ch4labs.dto.review.ReviewQueryResponse;
import com.example.ch4labs.dto.review.ReviewSearchRequest;

public interface ReviewQueryRepository {
    ReviewQueryResponse search(ReviewSearchRequest req);
}
