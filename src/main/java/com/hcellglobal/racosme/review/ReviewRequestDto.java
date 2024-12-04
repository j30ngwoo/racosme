package com.hcellglobal.racosme.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDto {

    @NotBlank(message = "Nickname is required.")
    private String nickname;

    @Min(value = 1, message = "Score must be at least 1.")
    @Max(value = 5, message = "Score must not exceed 5.")
    private int score;

    @NotBlank(message = "Content is required.")
    private String content;

    private String image;
}
