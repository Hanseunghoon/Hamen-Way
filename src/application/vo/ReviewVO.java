package application.vo;

import java.sql.Date;

public class ReviewVO {
	private int reviewNo;
	private String reviewComment;
	private String reviewWriteDate;
	private double reviewTasteRating;
	private String memberNickName;
	private String reviewMemberId;
	

	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public ReviewVO() {
	}
	
	public ReviewVO(String memberNickName, String reviewComment, String reviewWriteDate, double reviewTasteRating) {
		this.memberNickName = memberNickName;
		this.reviewComment = reviewComment;
		this.reviewWriteDate = reviewWriteDate;
		this.reviewTasteRating = reviewTasteRating;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	public String getReviewWriteDate() {
		return reviewWriteDate;
	}

	public void setReviewWriteDate(String writtenDate) {
		this.reviewWriteDate = writtenDate;
	}

	public double getReviewTasteRating() {
		return reviewTasteRating;
	}

	public void setReviewTasteRating(double reviewTastyRating) {
		this.reviewTasteRating = reviewTastyRating;
	}

	public String getReviewMemberId() {
		return reviewMemberId;
	}

	public void setReviewMemberId(String reviewMemberId) {
		this.reviewMemberId = reviewMemberId;
	}

}