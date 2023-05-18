package coffee;

public class Coffee {
	private int price;
	private int amount;

	public Coffee(int price, int amount) {
		this.price = price;
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
