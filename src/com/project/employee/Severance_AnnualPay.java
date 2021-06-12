package com.project.employee;

import java.util.Scanner;

public class Severance_AnnualPay {

	private static Scanner scan;

	static {
		scan = new Scanner(System.in);
	}

	public void severance_AnnualPay() {

		System.out.println("<퇴직금>");
		System.out.println("===================");
		System.out.println("1. 퇴직금");
		System.out.println("===================");
		System.out.print("선택(0:목록으로): ");

		String sel = scan.nextLine();

		if (sel.equals("1")) {
			// 퇴직금
			Severance s = new Severance();
			s.severance();
			
		} else {
			EmployeeOption.option();
		}

	}

}
