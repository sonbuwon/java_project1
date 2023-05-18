package employee;

import java.util.Scanner;

import coffee.Coffee;
import system.SystemService;

public class EmployeeService {
	// 서비스 개시할시 직원 객체 생성
	private Employee employee;
	public SystemService systemService = new SystemService();

	// singleton으로 생성?
	public EmployeeService() {
		if (employee == null) {
			employee = new Employee();
		}
	}

	public Employee getEmployee() {
		return employee;
	}

	// 선택할 수 있는 메뉴 출력
	public void printMenuOption() {
		systemService.printCoffeeImage();
		System.out.println("░\tKOSMO CAFE 직원메뉴입니다.\t\t░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░\t1.메뉴 등록\t2.메뉴 보기\t░░");
		System.out.println("░\t3.재고 추가\t4.매장 정리\t░░");
		System.out.println("░\t0.직원메뉴종료\t\t\t░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.print(":");
	}

	public void menuSetFunc() {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n메뉴 등록을 선택하셨습니다.");
		System.out.println("등록하실 커피의 종류, 개수, 가격을 순서대로 입력해주세요.");
		// 공백 문자열을 어떻게 받을것인가? 공백 문자열 처리를 어떻게 할 것인가?
		System.out.print("커피명:");
		String coffeeType = sc.nextLine().toUpperCase();
		System.out.print("개수:");
		Integer coffeeAmount = Integer.parseInt(sc.next());
		System.out.print("가격:");
		Integer coffeePrice = Integer.parseInt(sc.next());
		employee.setCoffee(coffeeType, new Coffee(coffeePrice, coffeeAmount));
	}

	public void showMenuFunc() {
		employee.showCoffeeMenu();
	}

	public void addStuckFunc() {
		employee.addCoffeeStock();
	}

	// 등록된 메뉴를 전부 삭제
	public void clearMenuFunc() {
		employee.clearMenu();
	}
}
