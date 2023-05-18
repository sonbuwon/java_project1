package system;

public class SystemService {
	private boolean programExit;
	private boolean employeeMenuExit;
	private boolean customerMenuExit;

	private int programOpt;
	private int customerMenuOpt;
	private int employeeMenuOpt;

	public SystemService() {
		// canExit
		this.programExit = false;
		this.employeeMenuExit = false;
		this.customerMenuExit = false;

		// MenuOpt
		this.programOpt = 0;
		this.customerMenuOpt = 0;
		this.employeeMenuOpt = 0;
	}

	// Getter, Setter

	public int getProgramOpt() {
		return programOpt;
	}

	public boolean isProgramExit() {
		return programExit;
	}

	public void setProgramExit(boolean programExit) {
		this.programExit = programExit;
	}

	public boolean isEmployeeMenuExit() {
		return employeeMenuExit;
	}

	public void setEmployeeMenuExit(boolean employeeMenuExit) {
		this.employeeMenuExit = employeeMenuExit;
	}

	public boolean isCustomerMenuExit() {
		return customerMenuExit;
	}

	public void setCustomerMenuExit(boolean customerMenuExit) {
		this.customerMenuExit = customerMenuExit;
	}

	public void setProgramOpt(int programOpt) {
		this.programOpt = programOpt;
	}

	public int getCustomerMenuOpt() {
		return customerMenuOpt;
	}

	public void setCustomerMenuOpt(int customerMenuOpt) {
		this.customerMenuOpt = customerMenuOpt;
	}

	public int getEmployeeMenuOpt() {
		return employeeMenuOpt;
	}

	public void setEmployeeMenuOpt(int employeeMenuOpt) {
		this.employeeMenuOpt = employeeMenuOpt;
	}

	// Print
	public void printMainMenu() {
		this.printCoffeeImage();
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░\t1.고객메뉴\t\t2.직원메뉴\t\t░░");
		System.out.println("░\t0.프로그램종료\t\t\t░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.print(":");
	}

	public void printSayGoodBye() {
		this.printCoffeeImage();
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("\t\t안녕히 가세요!");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
	}

	public void inputWrongInfo() {
		System.out.println("\n정보를 잘못입력하셨습니다. (정수만 입력가능)\n");
	}

	public void inputWrongMenu() {
		System.out.println("\n메뉴를 잘못 선택하셨습니다.\n");
	}

	// Print Coffee Image
	public void printCoffeeImage() {
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░▄█░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░▄▄█▀░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░░███▀░█░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░▄██░▄█▀░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░▀████░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░░▀█░█░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░██████████████████▀▀▄░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░██████████████████░░██░░░░░░░░░");
		System.out.println("░░░░░░░░░░░██████████████████▄▄▀░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░▀████████████████▀░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░▀█████████████░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░▄▄▄▄▄▄▄██████████▄▄▄▄▄▄▄░░░░░░░░░░");
		System.out.println("░░░░░░░░▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
	}
}
