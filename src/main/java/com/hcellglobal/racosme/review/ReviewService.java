package com.hcellglobal.racosme.review;

import com.hcellglobal.racosme.image.ImageEntity;
import com.hcellglobal.racosme.image.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ImageRepository imageRepository;

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
        review.setInstagramUrl(requestDto.getInstagramUrl());

        ReviewEntity savedReview = reviewRepository.save(review);

        if (requestDto.getImages() != null) {
            List<ImageEntity> images = requestDto.getImages()
                    .stream()
                    .map(imageUrl -> {
                        ImageEntity image = new ImageEntity();
                        image.setUrl(imageUrl);
                        image.setReview(savedReview); // 연관 설정
                        return image;
                    })
                    .collect(Collectors.toList());
            imageRepository.saveAll(images);
        }
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
