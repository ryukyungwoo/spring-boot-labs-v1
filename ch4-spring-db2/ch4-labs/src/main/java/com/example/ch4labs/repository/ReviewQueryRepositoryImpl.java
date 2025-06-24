package com.example.ch4labs.repository;

import com.example.ch4labs.domain.QReview;
import com.example.ch4labs.domain.Review;
import com.example.ch4labs.dto.review.ReviewQueryResponse;
import com.example.ch4labs.dto.review.ReviewResponse;
import com.example.ch4labs.dto.review.ReviewSearchRequest;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ReviewQueryRepositoryImpl implements ReviewQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public ReviewQueryResponse search(ReviewSearchRequest req) {

        QReview review = QReview.review;

        BooleanBuilder builder = new BooleanBuilder();

        if(StringUtils.hasText(req.getAuthor())) {
            builder.and(review.author.eq(req.getAuthor()));
        }
        if(StringUtils.hasText(req.getBookTitle())) {
            builder.and(review.bookTitle.eq(req.getBookTitle()));
        }
        if(StringUtils.hasText(req.getBookTitleContains())) {
            builder.and(review.bookTitle.contains(req.getTitleContains()));
        }
        if(StringUtils.hasText(req.getTitleContains())) {
            builder.and(review.title.contains(req.getTitleContains()));
        }
        if(StringUtils.hasText(req.getContentContains())) {
            builder.and(review.content.contains(req.getContentContains()));
        }
        if(req.getRating() != null && StringUtils.hasText(String.valueOf(req.getRating()))) {
            builder.and(review.rating.eq(req.getRating()));
        }
        if(req.getMinRating() != null && StringUtils.hasText(String.valueOf(req.getMinRating()))) {
            builder.and(review.rating.goe(req.getMinRating()));
        }
        if(req.getMaxRating() != null && StringUtils.hasText(String.valueOf(req.getMaxRating()))) {
            builder.and(review.rating.loe(req.getMaxRating()));
        }

        List<OrderSpecifier> orderSpecifiers = new ArrayList<>();

        if(req.getSort() != null){
            if (req.getSort()[0].equals("author")) {
                if (req.getSort()[1].equals("asc")) {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.ASC, review.author));
                } else {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, review.author));
                }
            }
            if (req.getSort()[0].equals("bookTitle")) {
                if (req.getSort()[1].equals("asc")) {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.ASC, review.bookTitle));
                } else {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, review.bookTitle));
                }
            }
            if (req.getSort()[0].equals("bookTitleContains")) {
                if (req.getSort()[1].equals("asc")) {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.ASC, review.bookTitle));
                } else {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, review.bookTitle));
                }
            }
            if (req.getSort()[0].equals("bookAuthor")) {
                if (req.getSort()[1].equals("asc")) {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.ASC, review.bookAuthor));
                } else {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, review.bookAuthor));
                }
            }
            if (req.getSort()[0].equals("titleContains")) {
                if (req.getSort()[1].equals("asc")) {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.ASC, review.title));
                } else {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, review.title));
                }
            }
            if (req.getSort()[0].equals("contentContains")) {
                if (req.getSort()[1].equals("asc")) {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.ASC, review.content));
                } else {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, review.content));
                }
            }
            if (req.getSort()[0].equals("rating")) {
                if (req.getSort()[1].equals("asc")) {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.ASC, review.rating));
                } else {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, review.rating));
                }
            }
            if (req.getSort()[0].equals("createdAt")) {
                if (req.getSort()[1].equals("asc")) {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.ASC, review.createdAt));
                } else {
                    orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, review.createdAt));
                }
            }
        } else {
            orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, review.createdAt));
        }

        OrderSpecifier[] orders = orderSpecifiers.toArray(new OrderSpecifier[orderSpecifiers.size()]);

        Pageable pageable = PageRequest.of(Optional.ofNullable(req.getPage()).orElse(0), Optional.ofNullable(req.getSize()).orElse(10));

        List<Review> content =  queryFactory.selectFrom(review)
                .where(builder)
                .orderBy(orders)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

        Long total = queryFactory.select(review.count())
                .from(review)
                .where(builder)
                .fetchOne();

        return new ReviewQueryResponse(content.stream().map(ReviewResponse::from).toList(), Integer.valueOf(String.valueOf(total)), (int)Math.ceil(total / pageable.getPageSize()), pageable.getPageSize(), pageable.getPageNumber());
    }
}
