package com.project.manager;

import java.util.Scanner;

public class DocumentManage {
	
	private static Scanner scan;

	static {
		scan = new Scanner(System.in);
	}
	
	public void documentManage() {
		
		System.out.println("===================");
		System.out.println("1. 근태 서류");
		System.out.println("2. 코로나 자가진단서");
		System.out.println("===================");
		System.out.print("번호 입력(0: 뒤로가기): ");
		String sel = scan.nextLine();
		
		if(sel.equals("1")) {
			CommuteDocument cd = new CommuteDocument();
			cd.commuteDocument();
		}else if(sel.equals("2")){
			CovidDocument covid = new CovidDocument();
			covid.covidDocument();
			
		}else {
			
		}
		
	}
	
}
