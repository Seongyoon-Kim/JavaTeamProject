package com.project.employee;

import java.util.Scanner;

import com.project.MainClass;

public class EmployeeOption {

	private static Scanner scan;

	static {
		scan = new Scanner(System.in);
	}

	public static void option() {

		boolean loop = true;

		String sel = menu();

		/**
		 * 메뉴를 고르는 코드입니다.
		 */

		while (loop) {

			if (sel.equals("1")) {

				// schedule(); //스케줄 확인
				pause();
				option();

			} else if (sel.equals("2")) {

				// annualLeave(); //연차 신청
				pause();
				option();

			} else if (sel.equals("3")) {

				// commute(); //근태 관리
				Commute c = new Commute();
				c.commute();
				pause();
				option();

			} else if (sel.equals("4")) {
				
				//서류 서명
				Document d = new Document();
				d.document(); 
				pause();
				option();

			} else if (sel.equals("5")) {
				
				//코로나 자가진단
				Covid c = new Covid();
				c.covid(); 
				pause();
				option();
				
			} else if (sel.equals("6")) {

				// salary(); //급여 명세서
				Salary s = new Salary();
				s.salary();
				pause();
				option();

			} else if (sel.equals("7")) {
				//퇴직금 및 연차수당
				Severance_AnnualPay sp = new Severance_AnnualPay();
				sp.severance_AnnualPay();
				pause();
				option();

			} else if (sel.equals("8")) {

				// welfare(); //복지포인트
				pause();
				option();

			} else if (sel.equals("9")) {

				// yearEndTax(); //연말정산
				pause();
				option();

			} else if (sel.equals("10")) {

				// notice(); //공지사항 게시판
				pause();
				option();

			} else if (sel.equals("11")) {

				// anonymous(); //익명게시판
				pause();
				option();

			} else if(sel.equals("0")){
				// 종료
				System.out.println("로그인화면으로 돌아갑니다.");
				MainClass.login();
			}else {
				System.out.println("번호를 다시 선택해주세요.");
				menu();
			}

		} // while
		
		

	}//option

	public static String menu() {

		System.out.println("===================");
		System.out.println("1. 스케줄 확인");
		System.out.println("2. 연차 신청");
		System.out.println("3. 근태 관리");
		System.out.println("4. 서류 서명");
		System.out.println("5. 코로나 자가진단");
		System.out.println("6. 급여 명세서");
		System.out.println("7. 퇴직금 및 연차수당");
		System.out.println("8. 복지 포인트");
		System.out.println("9. 연말 정산");
		System.out.println("10. 공지사항 게시판");
		System.out.println("11. 익명 게시판");
		System.out.println("===================");
		System.out.print("선택(0:로그인 화면이동): ");

		String sel = scan.nextLine();

		return sel;

	}
	
	private static void pause() {
		System.out.println("Enter를 누르시면 목록으로 이동합니다.");
		scan.nextLine();// Block
	}// pause

}
