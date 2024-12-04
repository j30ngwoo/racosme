package com.hcellglobal.racosme.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping()
    public List<ReviewResponseDto> getReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping()
    public ResponseEntity<String> createReview(@RequestBody ReviewRequestDto requestDto) {
        reviewService.createReview(requestDto);
        return ResponseEntity.ok("Review created successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok("Review deleted successfully!");
    }
}
