package customer;

import java.util.HashMap;

import coffee.Coffee;

public class Customer {
	private String name;
	private Integer balance;
	// 이후 필요한 필드는? 소지하고 있는 커피?

	public Customer() {

	}

	// Getter, Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	// Customer의 기능
	// 잔액을 충전하는 기능
	public void addBalance(Integer amount) {
		this.balance += amount;
	}

	// 잔액 확인하는 기능
	public void checkBalance() {
		System.out.println(getName() + "고객님의 현재 잔액은 " + this.balance + "원입니다.\n");
	}

	// 매개변수로 (재고에 등록된 커피, 구매 할 커피명, 구매 할 커피 개수)
	// 상품을 구매하는 기능
	public void buyCoffee(HashMap<String, Coffee> coffeeMap, String coffeeType, Integer coffeeCount) {
		if (coffeeMap == null) {
			System.out.println("메뉴에 등록된 커피가 없습니다.\n");
			return;
		}
		// 커피가 메뉴에 제대로 등록되어있는지 확인부터
		if (!coffeeMap.containsKey(coffeeType)) {
			System.out.println(coffeeType + "는(은) 메뉴에 등록되지 않았습니다.\n");
			return;
		}

		// 고객의 잔액이 구매금액보다 적을경우 결제 거절
		if (this.getBalance() < coffeeMap.get(coffeeType).getPrice() * coffeeCount) {
			System.out.println("고객님의 잔액은 " + this.getBalance() + "원입니다.");
			System.out.println("결제하실 금액은 " + coffeeMap.get(coffeeType).getPrice() * coffeeCount + "원입니다.\n"
					+ "고객님의 잔액이 부족하여 결제하실 수 없습니다. 잔액 충전을 부탁드립니다.\n");
			return;
		}
		// 개수가 모자랄경우 결제 거절
		if (coffeeMap.get(coffeeType).getAmount() < coffeeCount) {
			System.out.println("고객님이 주문하신 " + coffeeType + "는(은) " + coffeeCount + "개이고");
			System.out.println(coffeeType + "의 재고는 " + coffeeMap.get(coffeeType).getAmount() + "개입니다.");
			System.out.println("죄송합니다. 남은 재고에 맞춰서 주문해주시면 감사하겠습니다.\n");
			return;
		}

		System.out.println("\n" + coffeeType + "를 " + coffeeCount + "개 구매하셨습니다.");
		System.out.println("총 결제 금액은 " + coffeeMap.get(coffeeType).getPrice() * coffeeCount + "원입니다.");
		this.setBalance(this.getBalance() - coffeeMap.get(coffeeType).getPrice() * coffeeCount);
		// 구매한 커피만큼 개수 차감
		coffeeMap.get(coffeeType).setAmount(coffeeMap.get(coffeeType).getAmount() - coffeeCount);
		System.out.println("결제후 고객님의 잔액은 " + this.getBalance() + "원입니다.\n");
		System.out.println("결제후 남은 " + coffeeType + "의 개수는 " + coffeeMap.get(coffeeType).getAmount() + "개입니다.\n");
	}
}
