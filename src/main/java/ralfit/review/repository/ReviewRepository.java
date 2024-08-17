package ralfit.review.repository;

import org.springframework.stereotype.Service;
import ralfit.review.dto.ReviewDto;
import ralfit.review.service.ReviewService;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewRepository {

    String url = "jdbc:sqlite:reviewsRalfit.db";

    public List<ReviewDto> getAllReviews() throws SQLException {
        String sql = "SELECT * FROM reviews ORDER BY id DESC";
        try (var conn = DriverManager.getConnection(url);
             var query = conn.prepareStatement(sql)) {
            var rs = query.executeQuery();
            List<ReviewDto> reviews = new ArrayList<ReviewDto>();
            while (rs.next()) {
                ReviewDto dto = new ReviewDto();
                dto.setId(rs.getInt("id"));
                dto.setTitle(rs.getString("title"));
                dto.setBody(rs.getString("body"));
                dto.setUser(rs.getString("name"));
                reviews.add(dto);
            }

            return reviews;
        }
    }
    public void saveReview(ReviewDto review) throws SQLException {
        String sql = "INSERT INTO reviews (title, body, name) VALUES ( ?, ?, ?)";
        try (var conn = DriverManager.getConnection(url);
             var query = conn.prepareStatement(sql)) {
            query.setString(1, review.getTitle());
            query.setString(2, review.getBody());
            query.setString(3, review.getUser());
            query.executeUpdate();
        }
    }

    public void updateReview(ReviewDto review) throws SQLException {
        String sql = "UPDATE reviews SET title = ?, body = ?, name = ? WHERE id = ?";
        try (var conn = DriverManager.getConnection(url);
             var query = conn.prepareStatement(sql)) {
            query.setString(1, review.getTitle());
            query.setString(2, review.getBody());
            query.setString(3, review.getUser());
            query.setInt(4, review.getId());
            query.executeUpdate();
        }
    }

    public List<ReviewDto> getAllReviewsById(String id) throws SQLException {
        String sql = "SELECT * FROM reviews WHERE id = \'" + id + "\' ORDER BY id DESC";

        System.out.println(sql);
        try (var conn = DriverManager.getConnection(url);
             var query = conn.prepareStatement(sql)) {
            var rs = query.executeQuery();
            List<ReviewDto> reviews = new ArrayList<ReviewDto>();
            while (rs.next()) {
                ReviewDto dto = new ReviewDto();
                dto.setId(rs.getInt("id"));
                dto.setTitle(rs.getString("title"));
                dto.setBody(rs.getString("body"));
                dto.setUser(rs.getString("name"));
                reviews.add(dto);
            }

            return reviews;
        }
    }
}
