package com.project.employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;

import com.project.MainClass;

public class OutCheck {
	
	private final static String DATA;
	public static Calendar now = Calendar.getInstance();
	public static String endTime;

	static {
		DATA = "C:\\Project\\직원출퇴근더미.txt";
		endTime = "";
	}
	
	public void outCheck() {
		
		System.out.println("<퇴근 체크>");
		System.out.println("=====================");
		String endTime = String.format("%02d:%02d", now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE));
		// 캘린더를 이용해서 퇴근 체크를 누른 시간을 불러와서 퇴근시간을 endTime 변수에 저장한다.
		System.out.print("현재시각: " + endTime);
		System.out.println("\n퇴근시간 체크 완료되었습니다.");
		System.out.println("=====================");
		
		System.out.printf("%s - %s",InCheck.startTime, endTime );
		
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(DATA, true));
			// 2021-05-11■김민지■07:02■18:51■ - > 직원출퇴근더미 파일에 내용 추가

			writer.write(
					String.format("\n%d-%02d-%02d■%s■%s■%s■%s", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1,
							now.get(Calendar.DATE), MainClass.logEmployee.getName(), InCheck.startTime,endTime, MainClass.logEmployee.getEmployeeNum()));
			
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
