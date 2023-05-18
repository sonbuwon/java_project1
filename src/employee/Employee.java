package employee;

import java.util.HashMap;
import java.util.Scanner;

import coffee.Coffee;

public class Employee {
	private HashMap<String, Coffee> coffeeMap;

	public HashMap<String, Coffee> getCoffeeMap() {
		return coffeeMap;
	}

	// Employee의 기능? 1) 커피 등록 2) 커피 재고 충전
	public void setCoffee(String coffeeType, Coffee coffeeStock) {
		// 커피 등록이 처음 일 경우
		if (coffeeMap == null || coffeeMap.size() == 0) {
			coffeeMap = new HashMap<String, Coffee>();
			System.out.println("\n" + coffeeType + "는(은) 첫 커피 등록입니다.");
		}
		// 이미 등록되어있는 커피의 경우, 또 등록할시 거절
		if (coffeeMap.containsKey(coffeeType)) {
			System.out.println("\n" + coffeeType + "는(은) 이미 등록된 커피입니다.\n재고 추가만 가능합니다.\n");
			return;
		}
		// 등록이 처음 아니고, 새로 추가하는 커피라면
		coffeeMap.put(coffeeType, coffeeStock);
		System.out.println(
				coffeeType + "가 " + coffeeStock.getAmount() + "개 등록되었습니다.\n가격은 " + coffeeStock.getPrice() + "원입니다.\n");
	}

	// 현재 재고에 등록된 커피의 종류를 출력
	public void showCoffeeMenu() {
		// 재고에 등록된 커피가 없다면
		if (coffeeMap == null || coffeeMap.size() == 0) {
			System.out.println("\n메뉴에 등록된 커피가 없습니다.\n");
			return;
		}

		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░  ░  ░\t메뉴에 등록된 커피");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		for (String coffee : coffeeMap.keySet()) {
			System.out.println("░ " + coffee + "  " + coffeeMap.get(coffee).getAmount() + "개  "
					+ coffeeMap.get(coffee).getPrice() + "원");
		}
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
	}

	// 커피명에 따른 재고 확인
	public void checkCoffeeStock(String coffeeType) {
		if (coffeeMap == null || coffeeMap.size() == 0) {
			System.out.println("\n메뉴에 등록된 커피가 없습니다.\n");
			return;
		}

		if (coffeeMap.containsKey(coffeeType)) {
			System.out.println("\n" + coffeeType + "의 재고는 " + coffeeMap.get(coffeeType) + "개 입니다.\n");
		} else {
			System.out.println("\n입력하신 커피는 메뉴에 등록되지 않았습니다.\n");
		}
	}

	// 등록된 메뉴 재고 추가
	public void addCoffeeStock() {
		if (coffeeMap == null || coffeeMap.size() == 0) {
			System.out.println("\n메뉴에 등록된 커피가 없습니다.\n");
			return;
		}

		System.out.println("\n재고 추가를 선택하셨습니다.");

		// 메뉴보고 추가할 수 있게끔
		this.showCoffeeMenu();

		System.out.println("\n추가하실 커피의 종류, 개수를 순서대로 입력해주세요.");
		Scanner sc = new Scanner(System.in);
		System.out.print("커피명:");
		String coffeeType = sc.nextLine().toUpperCase();
		System.out.print("추가 할 개수:");
		Integer coffeeAmount = Integer.parseInt(sc.next());
		if (coffeeMap.containsKey(coffeeType)) {
			coffeeMap.get(coffeeType).setAmount(coffeeMap.get(coffeeType).getAmount() + coffeeAmount);
		} else {
			System.out.println("\n" + coffeeType + "는(은) 등록되지 않는 커피입니다.\n");
			return;
		}

		// 기존 개수에다가 추가된 개수까지 출력
		System.out.println(
				coffeeType + "가 " + coffeeAmount + "잔 추가되어 총 개수는 " + coffeeMap.get(coffeeType).getAmount() + "잔입니다.\n");
	}

	public void clearMenu() {
		if (coffeeMap == null || coffeeMap.size() == 0) {
			System.out.println("\n메뉴에 등록된 커피가 없습니다.\n");
			return;
		}

		System.out.println("\n메뉴에 등록된 커피를 다 폐기합니다.\n");
		coffeeMap.clear();
	}
}
