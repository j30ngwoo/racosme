package com.hcellglobal.racosme.review;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<ReviewResponseDto> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(ReviewResponseDto::new)
                .collect(Collectors.toList());
    }

    public void createReview(ReviewRequestDto requestDto) {
        ReviewEntity review = new ReviewEntity();
        review.setNickname(requestDto.getNickname());
        review.setScore(requestDto.getScore());
        review.setContent(requestDto.getContent());
        review.setImage(requestDto.getImage());

        reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
