package com.project.employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;

import com.project.MainClass;

public class Salary {

	public static Calendar now = Calendar.getInstance();
	private final static String DATA;
	public static int basePay;
	public static int bonus;
	public static int lunchPay;
	public static int overtimePay;
	public static int positionPay;
	public static int welfarePay;
	public static int timePay;
	public static int endTimeHour;
	public static int lastworkday;

	static {
		DATA = "C:\\Project\\직원출퇴근더미.txt";
		basePay = 0; // 기본급
		bonus = 0; // 상여금
		lunchPay = 0; // 식대
		overtimePay = 0;// 야근수당
		positionPay = 0;// 직책수당
		welfarePay = 0; // 복리후생비
		timePay = 0; // 시급
		endTimeHour = 0; // 끝나는 시간의 시

	}

	public void salary() {
		System.out.printf("<%d 급여명세서>", now.get(Calendar.MONTH));
		System.out.println("======================");
		System.out.printf("사원명 : %s\n", MainClass.logEmployee.getName());
		System.out.printf("사원번호 : %s\n", MainClass.logEmployee.getEmployeeNum());
		System.out.printf("지급연월 : %s년 %s월\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH));
		System.out.printf("소속 : %s %s\n", MainClass.logEmployee.getDivision(), MainClass.logEmployee.getPosition());
		System.out.println("======================");
		System.out.println("지급내역");
		System.out.println("======================");

		if (MainClass.logEmployee.getPosition().equals("부장")) {
			basePay = 4000000;
			positionPay = 400000;
			overtimepay();
		}else if (MainClass.logEmployee.getPosition().equals("차장")) {
			basePay = 3000000;
			positionPay = 300000;
			overtimepay();
		}else if (MainClass.logEmployee.getPosition().equals("과장")) {
			basePay = 2500000;
			positionPay = 250000;
			overtimepay();
		}else if (MainClass.logEmployee.getPosition().equals("대리")) {
			basePay = 2000000;
			positionPay = 200000;
			overtimepay();
		}else if (MainClass.logEmployee.getPosition().equals("사원")) {
			basePay = 1800000;
			positionPay = 180000;
			overtimepay();

		}else {
			System.out.println("해당 정보가 없습니다.");
		}

		System.out.printf("기본급 :\t%,10d원\n", basePay);
		System.out.printf("직책수당 :%,10d원\n", positionPay);
		lunchPay();
		System.out.printf("식대: %,10d원\n", lunchPay);
		bonus = (int) (basePay * 0.05);

		System.out.printf("상여금: %,10d원\n", bonus);
		System.out.printf("야근수당: %,10d원\n", overtimePay);
		System.out.printf("복리후생비: %,d원\n", 123000);

		int getSum = basePay + positionPay + bonus + lunchPay + overtimePay + 123000;

		System.out.println("======================");
		System.out.println("공제내역");
		System.out.println("======================");
		System.out.printf("국민연금: %,d\n", (int)(getSum * 0.045));
		System.out.printf("건강보험: %,d\n", (int)(getSum * 0.0343));
		System.out.printf("고용: %,d\n", (int)(getSum * 0.008));
		System.out.printf("근로소득세: %,d\n", (int)(getSum * 0.01));

		int taxSum = (int) (getSum * 0.045 + getSum * 0.0343 + getSum * 0.008 + getSum * 0.01);

		System.out.println("======================");
		
		System.out.printf("지급합계: %,d\n", getSum);
		System.out.printf("공제합계: %,d\n", taxSum);
		System.out.printf("실지급액: %,d\n", (getSum - taxSum));
		System.out.println("======================");
		System.out.println();
		System.out.println("귀하의 노고에 진심으로 감사합니다.");

	}// salary

	public static void overtimepay() {
	      try {

	         BufferedReader reader = new BufferedReader(new FileReader(DATA));

	         String line = "";

	            while ((line = reader.readLine()) != null) {
	                  //2021-01-04■김민수■07:49■18:51
	               
	               String[] temp = line.split("■");
	               
	                  if(((Integer.parseInt(temp[0].substring(5,7)) == now.get(Calendar.MONTH)))&&temp[1].equals(MainClass.logEmployee.getName())) {
	                     //1번째 방의 월이 저번달일 경우 그리고 2번방의 이름과 로그인 한 이름과 같을때
	                     
	                     endTimeHour = Integer.parseInt(temp[3].substring(0,2));
	                     //끝나는 시간의 시는 근태관리에서의 끝나는 시간의 시이다.
	                     int timePay = basePay/20/9 ; // 시급
	                     
	                     if(endTimeHour==19) {
	                        overtimePay += (int) (timePay *1.5);
	                     }else if(endTimeHour==20) {
	                        overtimePay += (int) (2*(timePay*1.5));
	                     }else if(endTimeHour==21) {
	                        overtimePay += (int) (3*(timePay*1.5));
	                     }else {
	                        overtimePay = 0;
	                     }
	                  }
	                  
	               
	               
	            } // while
	         reader.close();

	      } catch (Exception e) {
	         System.out.println(e);
	      }

	   
	   }
	   
	public static void lunchPay() {
	      
	      try {
	         
	         BufferedReader reader = new BufferedReader(new FileReader(DATA));
	         
	         String line = "";
	         
	         
	         while ((line = reader.readLine()) != null) {
	            //2021-01-04■김민수■07:49■18:51■20101010
	            String[] temp = line.split("■");
	            
	            System.out.println(Integer.parseInt(temp[0].substring(5,7)));
	            if(temp[4].equals(MainClass.logEmployee.getEmployeeNum())) {
	               
	               if((Integer.parseInt(temp[0].substring(5,7)) == now.get(Calendar.MONTH))) {
	                  lastworkday++;
	               }
	            }
	         } // while
	         
	         lunchPay = lastworkday * 8000;
	         
	      }catch (Exception e) {
	         System.out.println(e);
	      }

	}
	   
}//Salary
