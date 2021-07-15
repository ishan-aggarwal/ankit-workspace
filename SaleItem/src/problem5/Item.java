package problem5;

public class Item {

    private String title;
	private double originalUnitPrice;
	private int quantity;
	private DiscountPolicy discountPolicy;

	public Item(String title, double originalUnitPrice, int quantity) {
		this.title = title;
		this.originalUnitPrice = originalUnitPrice;
		this.quantity = quantity;
		this.discountPolicy = DiscountPolicy.BASIC;
	}

	public Item(String title, double originalUnitPrice, int quantity, DiscountPolicy discountPolicy) {
		this.title = title;
		this.originalUnitPrice = originalUnitPrice;
		this.quantity = quantity;
		this.discountPolicy = discountPolicy;
	}

	public double getItemTotal() {
		double itemTotal = 0;
		if(this.discountPolicy == DiscountPolicy.BASIC || quantity <= 1) {
			itemTotal = originalUnitPrice*quantity;
		} else if(this.discountPolicy == DiscountPolicy.MORE_THAN_ONE) {
			itemTotal = originalUnitPrice + ((originalUnitPrice*(quantity-1))/2.0);
		}
		return itemTotal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getOriginalUnitPrice() {
		return originalUnitPrice;
	}

	public void setOriginalUnitPrice(double originalUnitPrice) {
		this.originalUnitPrice = originalUnitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
