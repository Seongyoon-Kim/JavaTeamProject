package com.project.employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import com.project.MainClass;

/**
 * 
 * 코로나 자가진단서를 작성하여 
 * 질의응답을 파일에 저장하여
 * 관리자가 확인할 수 있도록 해주는 클래스
 * 
 *
 */

public class Covid {

	private final static String DATA;  // 설문조사 질문지가 저장되어있는 파일경로
	private final static String DATA2; // 완료된 설문조사를 저장할 파일경로

	private static Scanner scan;

	static {
		scan = new Scanner(System.in);
		DATA = "C:\\Project\\COVID.txt";
		DATA2 = "C:\\Project\\COVID완료.txt";
	}

	
	/**
	 * 설문지의 내용을 읽어오고 Scanner로 응답을 받아 파일에 저장해주는 메서드
	 */
	public void covid() {

		String answer = "";

		try {

			BufferedReader reader = new BufferedReader(new FileReader(DATA));
			BufferedWriter writer = new BufferedWriter(new FileWriter(DATA2,true));  //완료된 설문조사를 파일에 추가하기

			String line = "";
			
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			int month =now.get(Calendar.MONTH); 
			int day = now.get(Calendar.DATE);
			now.set(year, month,day);  // 설문조사 작성 날짜 설정
			
			//유민우■20198974■2021-05-07 // 이 형식으로 저장
			writer.write(String.format("%s■%s■%tF\n", 
											MainClass.logEmployee.getName(),
											MainClass.logEmployee.getEmployeeNum(),
											now));
			
			while ((line = reader.readLine()) != null) {
				
				//1.■질문
				String[] temp = line.split("■");
				System.out.print(temp[0]+temp[1]);
				answer = scan.nextLine(); 
				if (answer.toLowerCase().equals("y") || answer.toLowerCase().equals("n")) {
					// System.out.println();
					writer.write(String.format("%s. ■%s: ■%s\n", temp[0], temp[1], answer.toLowerCase()));
				} else if (answer.equals("0")) { // 답변이 0이면 설문조사를 멈추고 되돌아간다.
					EmployeeOption.option();
				} else {
					System.out.print(temp[0]+temp[1]);
					answer = scan.nextLine(); 
					question(answer, writer, temp);					
				}		
				
			} // while
			
			writer.write("==========\n");
			writer.close();
			reader.close();

		} catch (Exception e) {
			System.out.println("load: " + e);
		}

	}//covid


	private void question(String answer, BufferedWriter writer, String[] temp) throws IOException {
		if (answer.toLowerCase().equals("y") || answer.toLowerCase().equals("n")) {
			// System.out.println();
			writer.write(String.format("%s. ■%s: ■%s\n", temp[0], temp[1], answer.toLowerCase()));
		} else if (answer.equals("0")) { // 답변이 0이면 설문조사를 멈추고 되돌아간다.
			EmployeeOption.option();
		} else {
			System.out.print(temp[0]+temp[1]);
			answer = scan.nextLine(); 
			question(answer, writer, temp);	
		}
	}

}//Covid
