package ralfit.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ralfit.review.dto.ReviewDto;
import ralfit.review.repository.ReviewRepository;

import java.sql.SQLException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public List<ReviewDto> getAllReviews() throws SQLException {
        return reviewRepository.getAllReviews();
    }

    public List<ReviewDto> getReviewsById(String id) throws SQLException {
        return reviewRepository.getAllReviewsById(id);
    }

    public void addReview(ReviewDto reviewDto) throws SQLException {
        reviewRepository.saveReview(reviewDto);
    }

    public void updateReview(ReviewDto reviewDto) throws SQLException {
        reviewRepository.updateReview(reviewDto);
    }

}
