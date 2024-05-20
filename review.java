
public class review {
	
	private int star = 0;
	private String review = "null";
	private String username2 = "null";
	private String profile2 = "null";
	
	public review () {
		
	}
	
	public review (int star, String review, String username2, String profile2) {
		
		this.star = star;
		this.review = review;
		this.username2 = username2;
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
