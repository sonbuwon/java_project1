package customer;

import java.util.Scanner;

import employee.EmployeeService;
import system.SystemService;

public class CustomerService {
	private Customer customer;
	public SystemService systemService = new SystemService();

	public CustomerService() {

	}

	public Customer getCustomer() {
		return customer;
	}

	// service 기능
	// 선택할 수 있는 메뉴 출력
	public void printMenuOption() {
		systemService.printCoffeeImage();
		System.out.println("░\t어서오세요! KOSMO CAFE입니다.\t\t░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░\t1.고객 등록\t2.커피 구매\t░░");
		System.out.println("░\t3.잔액 확인\t4.잔액 충전\t░░");
		System.out.println("░\t0.구매종료\t\t\t\t░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.print(":");
	}

	// 고객 정보 등록
	public void registerCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("고객 등록을 선택하셨습니다.\n고객님은 고객정보를 입력해야합니다.");
		System.out.println("고객명과 충전하실 금액을 순서대로 입력해주세요.");
		System.out.print("고객명:");
		String customerName = sc.nextLine();
		System.out.print("충전하실금액:");
		Integer customerBalance = Integer.parseInt(sc.next());

		// 여기서 고객 객체 생성 (중요)
		customer = new Customer();
		customer.setBalance(customerBalance);
		customer.setName(customerName);

		System.out.println(customer.getName() + "고객님의 고객 등록이 완료되었습니다.\n");
	}

	// 고객 커피 구매
	public void getCoffee(EmployeeService employeeService) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n커피 구매를 선택하셨습니다.");
		if (customer == null) {
			System.out.println("고객이 등록되지 않았습니다. 고객등록을 먼저해주세요.\n");
			return;
		}
		// 커피가 재고에 등록되어 있다면 메뉴를 출력
		employeeService.showMenuFunc();
		// 메뉴에 등록된 커피가 없다면 return
		if (employeeService.getEmployee().getCoffeeMap() == null) {
			return;
		}

		System.out.println("구매하실 커피명과 개수를 순서대로 입력해주세요.");
		System.out.print("커피명:");
		String coffeeType = sc.nextLine().toUpperCase();
		System.out.print("개수:");
		Integer customerCoffeeCount = Integer.parseInt(sc.next());
		customer.buyCoffee(employeeService.getEmployee().getCoffeeMap(), coffeeType, customerCoffeeCount);
	}

	// 고객 잔액 충전
	public void rechargeBalance() {
		Scanner sc = new Scanner(System.in);
		int amount = 0;

		System.out.println("\n잔액 충전을 선택하셨습니다.");
		if (customer == null) {
			System.out.println("고객이 등록되지 않았습니다. 고객등록을 먼저해주세요.\n");
			return;
		}
		System.out.println(customer.getName() + "님이 고객 잔액 충전을 선택하셨습니다.");

		System.out.print("충전하실금액:");

		try {
			amount = Integer.parseInt(sc.next());
		} catch (Exception e) {
			systemService.inputWrongInfo();
			return;
		}
		System.out.println(customer.getName() + "고객님의 기존 잔액은 " + customer.getBalance() + "원이고 " + amount + "원 충전되어");
		customer.addBalance(amount);
		customer.checkBalance();
	}

	// 고객 잔액 확인
	public void showBalance() {
		System.out.println("\n잔액 확인을 선택하셨습니다.");
		if (customer == null) {
			System.out.println("고객이 등록되지 않았습니다. 고객등록을 먼저해주세요.\n");
			return;
		}
		customer.checkBalance();
	}
}