package coffeeshop;

import java.util.Scanner;

import customer.CustomerService;
import employee.EmployeeService;
import system.SystemService;

public class CoffeeShop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		CustomerService customerService = new CustomerService();
		EmployeeService employeeService = new EmployeeService();
		SystemService systemService = new SystemService();

		systemService.setProgramExit(false);

		while (!systemService.isProgramExit()) {
			systemService.setEmployeeMenuExit(false);
			systemService.setCustomerMenuExit(false);

			systemService.printMainMenu();
			try {
				systemService.setProgramOpt(Integer.parseInt(sc.nextLine()));
			} catch (Exception e) {
				systemService.inputWrongInfo();
				continue;
			}

			switch (systemService.getProgramOpt()) {
			case 1:
				while (!systemService.isCustomerMenuExit()) {
					customerService.printMenuOption();
					try {
						systemService.setCustomerMenuOpt(Integer.parseInt(sc.nextLine()));
					} catch (Exception e) {
						systemService.inputWrongInfo();
						continue;
					}

					switch (systemService.getCustomerMenuOpt()) {
					case 1:
						customerService.registerCustomer();
						break;
					case 2:
						customerService.getCoffee(employeeService);
						break;
					case 3:
						customerService.showBalance();
						break;
					case 4:
						customerService.rechargeBalance();
						break;
					case 0:
						systemService.setCustomerMenuExit(true);
						break;
					default:
						systemService.inputWrongMenu();
					}
				}
				break;
			case 2:
				while (!systemService.isEmployeeMenuExit()) {
					employeeService.printMenuOption();
					try {
						systemService.setEmployeeMenuOpt(Integer.parseInt(sc.nextLine()));
					} catch (Exception e) {
						systemService.inputWrongInfo();
						continue;
					}

					switch (systemService.getEmployeeMenuOpt()) {
					case 1:
						employeeService.menuSetFunc();
						break;
					case 2:
						employeeService.showMenuFunc();
						break;
					case 3:
						employeeService.addStuckFunc();
						break;
					case 4:
						employeeService.clearMenuFunc();
						break;
					case 0:
						systemService.setEmployeeMenuExit(true);
						break;
					default:
						systemService.inputWrongMenu();
					}
				}
				break;
			case 0:
				systemService.setProgramExit(true);
				break;
			default:
				systemService.inputWrongMenu();
			}
		}
		systemService.printSayGoodBye();
	}
}
