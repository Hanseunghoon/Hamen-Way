package application.vo;

public class RestaurantVO {
	private int restaurantNo;
	private String restaurantName;
	private String restaurantLocation;
	private double restaurantRating;
	private String restaurantCategory;

	public double getRestaurantRating() {
		return restaurantRating;
	}

	public void setRestaurantRating(double rrating) {
		this.restaurantRating = rrating;
	}

	public int getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantLocation() {
		return restaurantLocation;
	}

	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}

	public String getRestaurantCategory() {
		return restaurantCategory;
	}

	public void setRestaurantCategory(String restaurantCategory) {
		this.restaurantCategory = restaurantCategory;
	}
}
