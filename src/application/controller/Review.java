package application.controller;


public class Review {

	private String userNickName;
	private String rating;
	private String review;
	private String reviewWriteDate;
	
	
	public Review(String userNickName, String rating, String review, String reviewWriteDate) {
		this.userNickName = userNickName;
		this.rating = rating;
		this.review = review;
		this.reviewWriteDate=reviewWriteDate;
	}
	
	
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}


	public String getReviewWriteDate() {
		return reviewWriteDate;
	}


	public void setReviewWriteDate(String reviewWriteDate) {
		this.reviewWriteDate = reviewWriteDate;
	}
	
	
	
	
	
	
}
