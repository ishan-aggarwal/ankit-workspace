package problem2;

public class Item {

    private String title;
	private double originalUnitPrice;
	private int quantity;

	public Item(String title, double originalUnitPrice, int quantity) {
		this.title = title;
		this.originalUnitPrice = originalUnitPrice;
		this.quantity = quantity;
	}

	public double getItemTotal() {
		return originalUnitPrice*quantity;
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
