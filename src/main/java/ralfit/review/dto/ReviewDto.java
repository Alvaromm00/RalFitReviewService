package ralfit.review.dto;

import lombok.Data;

@Data
public class ReviewDto{
    private int id;
    private String title;
    private String body;
    private String user;
}
