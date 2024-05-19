package application.Controller;

import java.util.ArrayList;

import application.Entity.Review;
import application.Entity.ReviewEntity;
import javafx.collections.ObservableList;

public class AgentProfileController {
	
	private static ReviewEntity reviewEntity = new ReviewEntity();
	
	public static int getAvgRatings() {
		return reviewEntity.getAverageRatings();
	}
	
	
	public static ObservableList<Review> fetchReviews(String username, String profile) {
		return reviewEntity.getReviews(username, profile);
	}

}
