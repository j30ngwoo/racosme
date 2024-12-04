package com.hcellglobal.racosme.review;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewResponseDto {
    private Long id;
    private String nickname;
    private int score;
    private String content;
    private String image;
    private LocalDateTime updatedAt;

    public ReviewResponseDto(ReviewEntity review) {
        this.id = review.getId();
        this.nickname = review.getNickname();
        this.score = review.getScore();
        this.content = review.getContent();
        this.image = review.getImage();
        this.updatedAt = review.getUpdatedAt();
    }
}
