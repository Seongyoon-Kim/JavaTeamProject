package com.project.employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;

import com.project.MainClass;

public class InCheck {
	
	public static Calendar now = Calendar.getInstance();
	public static String startTime;
	private final static String DATA;
	
	static {
		startTime = "";
		DATA = "C:\\Project\\직원출퇴근더미_복사본.txt";
	}
	
	public void incheck() {
		
		System.out.println("<출근 체크>");
		System.out.println("=====================");
		// 캘린더를 이용해서 출근 체크를 누른 시간을 불러와서 출근시간을 startTime 변수에 저장한다.
		if(now.get(Calendar.HOUR_OF_DAY)<9) {
			
			startTime = String.format("%02d:%02d", now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE));
			System.out.print("현재시각: " + startTime);
			System.out.println("\n출근시간 체크 완료되었습니다");
			System.out.println("=====================");
		} else {
			startTime = String.format("%02d:%02d", now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE));
			System.out.println("\n현재시각 :" + startTime + " 지각하셨습니다.");
			System.out.println("=====================");
		}
//		
//		try {
//
//			BufferedWriter writer = new BufferedWriter(new FileWriter(DATA, true));
//			// 2021-05-11■김민지■07:02■18:51■ - > 직원출퇴근더미 파일에 내용 추가
//
//			writer.write(
//					String.format("\n%d-%02d-%02d■%s■%s", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1,
//							now.get(Calendar.DATE), MainClass.logEmployee.getName(), InCheck.startTime, MainClass.logEmployee.getEmployeeNum()));
//			
//			writer.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		
		
			
	}

}
