package application.vo;

public class MenuVO {
	private int menuNo;
	private String menuName;
	private int menuPrice;
	private String menuCategory;
	private int menuSpicy;

	public MenuVO() {
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}

	public int getMenuSpicy() {
		return menuSpicy;
	}

	public void setMenuSpicy(int menuSpicy) {
		this.menuSpicy = menuSpicy;
	}
	
}