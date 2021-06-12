package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.employee.*;
import com.project.manager.*;

/**
 * 
 * MainClass
 *
 */
public class MainClass {

	private static Scanner scan;
	private final static String DATA;
	private final static String DATA2;
	private final static String DATA3;
	public static ArrayList<Employee> list;
	public static ArrayList<EmployeeCommute> list2;
	public static Employee logEmployee;
	public static EmployeeCommute logCommute;

	static String id;
	static String pw;

	static {
		scan = new Scanner(System.in);
		DATA = "C:\\Project\\직원더미.txt";
		DATA2 = "C:\\Project\\직원연차더미.txt";
		DATA3 = "C:\\Project\\직원출퇴근더미.txt";
		list = new ArrayList<Employee>();
		list2 = new ArrayList<EmployeeCommute>();
		logEmployee = new Employee();
	}

	public static void main(String[] args) {

		load();  //main 클래스 시작하자마자 파일 -> ArrayList 데이터 담기
		commuteLoad();
		
		System.out.println("[프로젝트]");

		login(); // 로그인 화면  // 첫페이지
		
	}// main

	private static void commuteLoad() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DATA3));

			String line = "";

			while ((line = reader.readLine()) != null) {

				//2021-01-04■김민수■07:49■18:51
				EmployeeCommute  employeeCommute = new EmployeeCommute();

				String[] temp = line.split("■");
				employeeCommute.setCommuteDay(temp[0]);
				employeeCommute.setName(temp[1]);
				employeeCommute.setStartTime(temp[2]);
				employeeCommute.setEndTime(temp[3]);
				
				list2.add(employeeCommute);
			}
			
		} catch (Exception e) {
		}
		
	}
	
	/**
	 * 모든 직원 정보를 배열에 옮겨주는 메소드입니다.
	 */
	private static void load() {

		try {

			BufferedReader reader = new BufferedReader(new FileReader(DATA));

			String line = "";

			while ((line = reader.readLine()) != null) {

				Employee employee = new Employee();

				// 1■김민수■인사부■부장■2014-12-07■20147245■1973-04-02■010-7599-0093■성남시 강남구 신도림동 195번지

				String[] temp = line.split("■");

				employee.setName(temp[1]);
				employee.setDivision(temp[2]);
				employee.setPosition(temp[3]);
				employee.setJoinDate(temp[4]);
				employee.setEmployeeNum(temp[5]);
				employee.setBirth(temp[6]);
				employee.setPhoneNum(temp[7]);
				employee.setAddress(temp[8]);

				list.add(employee);

			} // while

			reader.close();

		} catch (Exception e) {
			System.out.println("load: " + e);
		}

	}// load

	/**
	 * 첫 화면
	 * 로그인 - 관리자(root), 직원(사원번호)
	 * ID/PW가 일치하면 목록띄워준다. 
	 * 
	 */
	public static void login() {

		System.out.println("===================");
		System.out.print("ID: ");
		id = scan.nextLine();
		System.out.println("");
		System.out.print("PW: ");
		pw = scan.nextLine();
		
		int i=0;
		for (Employee e : list) {
			i++;
			if (id.equals("root")) {
				if (pw.equals("0000")) {
					System.out.println("===================");
					System.out.println("관리자 등록");
					ManagerOption mo= new ManagerOption();
					mo.option();					
				} else {
					System.out.println("===================");
					System.out.println("비밀번호가 틀렸습니다.");
					login();
				}
			} else if (e.getEmployeeNum().equals(id)) {

				int index = e.getPhoneNum().lastIndexOf("-");
				e.getPhoneNum().substring(index + 1);
				if (pw.equals(e.getPhoneNum().substring(index + 1))) {
					System.out.println("===================");
					System.out.printf("%s로그인 완료\n", e.getName());
					
					for(EmployeeCommute ec : list2) {
						if(ec.getName().equals(e.getName())) {
							logCommute = ec;
						}
					}
					
					logEmployee = e;
					EmployeeOption.option();
//					EmployeeOption em = new EmployeeOption();
//					em.option();
				}else {
					System.out.println("===================");
					System.out.println("비밀번호가 틀렸습니다.");
					login();
				}
				
			} else {
				if(i==99) {
					System.out.println("===================");
					System.out.println("다시 입력하세요.");
					login();
				}
			}

		}

	
	}//login

}// MainClass