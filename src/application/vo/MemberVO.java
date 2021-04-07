package application.vo;

public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberNickName;
	private String memberLastName;
	private String memberFirstName;
	private int memberAge;
	private String isOwner;
	private String memberNonPrefCat;

	public String getIsOwner() {
		return isOwner;
	}

	public void setIsOwner(String isOwner) {
		this.isOwner = isOwner;
	}

	public String getMemberNonPrefCat() {
		return memberNonPrefCat;
	}

	public void setMemberNonPrefCat(String memberNonPrefCat) {
		this.memberNonPrefCat = memberNonPrefCat;
	}

	public MemberVO() {
	}

	public MemberVO(String memberId, String memberPw) {
		this.memberId = memberId;
		this.memberPw = memberPw;
	}

	public MemberVO(String memberId, String memberPw, String memberNickName, String memberLastName,
			String memberFirstName, int memberAge, String isOwner) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberNickName = memberNickName;
		this.memberLastName = memberLastName;
		this.memberFirstName = memberFirstName;
		this.memberAge = memberAge;
		this.isOwner = isOwner;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}

	public String getMemberFirstName() {
		return memberFirstName;
	}

	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getOwner() {
		return isOwner;
	}

	public void setOwner(String isOwner) {
		this.isOwner = isOwner;
	}

}