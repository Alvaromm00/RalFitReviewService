package ralfit.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ralfit.review.dto.ReviewDto;
import ralfit.review.service.ReviewService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    @GetMapping
    public List<ReviewDto> getAllReviews() throws SQLException {
        return reviewService.getAllReviews();
    }

    @PostMapping
    public ResponseEntity saveReview(@RequestBody ReviewDto review ) throws SQLException {
        reviewService.addReview(review);
        return ResponseEntity.ok().build();
    }



}
