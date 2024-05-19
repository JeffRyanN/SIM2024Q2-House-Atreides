package application.Entity;

public class Review {
	
	private int star = 0;
	private String review = "null";
	private String username2 = "null";
	private String profile2 = "null";
	
	public Review () {
		
	}
	
	public Review (int star, String review, String username2, String profile2) {
		
		this.star = star;
		this.review = review;
		this.username2 = username2;
		this.profile2 = profile2;
		
	}
	
	public void setStar(int star) {
		this.star = star;
	}
	
	public void setReview(String review) {
		this.review = review;
	}
	
	public void setUserName2(String username2) {
		this.username2 = username2;
	}
	
	public void setProfile2(String profile2) {
		this.profile2 = profile2;
	}
	//Get values
	
	public int getStar() {
		return star;
	}
	
	public String getReview() {
		return review;
	}
	
	public String getUsername2() {
		return username2;
	}
	
	public String getProfile2() {
		return profile2;
	}

}
