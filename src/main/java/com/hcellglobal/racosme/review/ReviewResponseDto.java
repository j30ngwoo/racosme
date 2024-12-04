package com.hcellglobal.racosme.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResponseDto {
    private Long id;
    private String nickname;
    private int score;
    private String content;
    private String image;

    public ReviewResponseDto(ReviewEntity review) {
        this.id = review.getId();
        this.nickname = review.getNickname();
        this.score = review.getScore();
        this.content = review.getContent();
        this.image = review.getImage();
    }
}
