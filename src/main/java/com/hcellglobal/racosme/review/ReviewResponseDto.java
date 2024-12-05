package com.hcellglobal.racosme.review;

import com.hcellglobal.racosme.image.ImageEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ReviewResponseDto {
    private Long id;
    private String nickname;
    private int score;
    private String content;
    private String instagramUrl;
    private List<String> images;
    private LocalDateTime updatedAt;

    public ReviewResponseDto(ReviewEntity review) {
        this.id = review.getId();
        this.nickname = review.getNickname();
        this.score = review.getScore();
        this.content = review.getContent();
        this.instagramUrl = review.getInstagramUrl();
        this.updatedAt = review.getUpdatedAt();
        this.images = review.getImages().stream().map(ImageEntity::getUrl).toList();
    }
}
