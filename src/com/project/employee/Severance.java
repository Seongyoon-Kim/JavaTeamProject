package com.project.employee;

import java.util.Calendar;
import java.util.Scanner;

import com.project.MainClass;

public class Severance {

	private static Calendar join;
	private static Calendar retire;
	private static Calendar threeMonth;

	private static Scanner scan;
	private static String retireDate;
	
	private static String joindate;
	private static int Three_totalWage;
	private static int totalBonus;
	private static int yearWage;
	private static long totalWorkDay;

	static {
		join = Calendar.getInstance();
		retire = Calendar.getInstance();
		threeMonth = Calendar.getInstance();
		scan = new Scanner(System.in);
		Three_totalWage = 0;
		totalBonus = 0;
		yearWage = 0;
	}

	public void severance() {

		System.out.println("<퇴직금>");
		System.out.println("===================");
		System.out.printf("입사일: %s\n", MainClass.logEmployee.getJoinDate());
		System.out.print("퇴직일 입력(숫자 8자리): ");
		retireDate = scan.nextLine();
		System.out.println("===================");

		joindate = MainClass.logEmployee.getJoinDate();
		int Jyear = Integer.parseInt(joindate.substring(0, 4));
		int Jmonth = Integer.parseInt(joindate.substring(5, 7));
		int Jday = Integer.parseInt(joindate.substring(8, 10));

		join.set(Jyear, Jmonth, Jday);

		// retireDate 20201010
		int Ryear = Integer.parseInt(retireDate.substring(0, 4));
		int Rmonth = Integer.parseInt(retireDate.substring(4, 6));
		int Rday = Integer.parseInt(retireDate.substring(6, 8));

		retire.set(Ryear, Rmonth, Rday);
		
		threeMonth.set(Ryear, Rmonth-3, Rday);
		System.out.printf("3개월 전 날짜:%tF", threeMonth);
		

		totalWorkDay = (retire.getTimeInMillis() - join.getTimeInMillis()) / 1000 / 60 / 60 / 24;

		
		System.out.println("<퇴직금>");
		System.out.println("===================");
		System.out.println("1. 평균임금 계산");
		System.out.println("2. 평균임금 직접입력");
		System.out.println("===================");
		System.out.print("번호입력(0:뒤로가기): ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			// 평균임금 계산
			averageAutoCal();

		} else if (sel.equals("2")) {
			// 평균임금 직접입력
			averagDayCal();
		} else {
			severance();
		}


	}

	private void averageAutoCal() {
		// 평균임금 계산기
		System.out.println("<평균임금 계산기>");
		System.out.println("===================");
		System.out.print("3개월 급여 총액입력(원): ");
		Three_totalWage = Integer.parseInt(scan.nextLine());
		System.out.print("연간 상여금 총액(원): ");
		totalBonus = Integer.parseInt(scan.nextLine());
		System.out.print("연차수당(원): ");
		yearWage = Integer.parseInt(scan.nextLine());
		System.out.println("===================");


		double total = Three_totalWage + (totalBonus * 3 /12) + (yearWage * 3 / 12);
		System.out.println("3개월 총액"+total);

		//3개월간 재직일수 
		long threeMonthtick = (retire.getTimeInMillis() - threeMonth.getTimeInMillis()) / 1000 / 60 / 60 / 24;

		double dayWage = (double)total / (threeMonthtick) ;
		
		double severance = dayWage * 30 * ((double)totalWorkDay / 365);
		
		System.out.printf("총 재직일수: %d일\n", totalWorkDay);
		System.out.printf("1일 평균임금: %,d원\n", (int)dayWage);
		System.out.printf("예상 퇴직금(세전기준): %,d원\n", (int) severance);
		System.out.println("약간의 오차가 발생할 수 있습니다.");
		
	}

	private void averagDayCal() {// 평균임금 직접입력

		System.out.println("<평균임금 직접입력>");
		System.out.println("===================");
		System.out.print("1일 평균 임금(원): ");
		int averageDayWage = Integer.parseInt(scan.nextLine());

		double severance = averageDayWage * 30 * ((double) totalWorkDay / (365));

		System.out.printf("재직일수: %d일\n", totalWorkDay);
		System.out.printf("평균임금: %,d원\n", averageDayWage);
		System.out.printf("예상 퇴직금(세전기준): %,d원\n", (int) severance);
		System.out.println("약간의 오차가 발생할 수 있습니다.");

	}// averagDayCal

}
