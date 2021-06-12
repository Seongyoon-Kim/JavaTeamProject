package com.project.manager;

import java.util.Scanner;

import com.project.MainClass;

public class ManagerOption {
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
				//직원관리
				EmployeeManage em = new EmployeeManage();
				em.employeeManage();
				pause();
				option();
				
			} else if (sel.equals("2")) {
				//결제서류
				DocumentManage dm = new DocumentManage();
				dm.documentManage();
				pause();
				option();
				
			} else if (sel.equals("3")) {
				//스케줄관리
				pause();
				option();
			} else if (sel.equals("4")) {
				//공지사항 게시판
				pause();
				option();
			}else if(sel.equals("0")){
				//종료
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
		System.out.println("1. 직원관리");
		System.out.println("2. 결제 서류");
		System.out.println("3. 스케줄 관리");
		System.out.println("4. 공지사항 게시판");
		System.out.println("===================");
		System.out.print("선택(0:로그인화면으로 돌아가기): ");

		String sel = scan.nextLine();

		return sel;

	}
	
	private static void pause() {
		System.out.println("엔터를 누르시면 목록으로 이동합니다.");
		scan.nextLine();// Block
	}// pause

}
