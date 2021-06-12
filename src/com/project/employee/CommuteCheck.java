package com.project.employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

import com.project.EmployeeCommute;
import com.project.MainClass;

public class CommuteCheck {

	private final static String DATA;
	public static int workday;
	public static int lateday;
	public static int absenceday;
	public static int earlyleaveday;
	public static int lastworkday;

	public static ArrayList<EmployeeCommute> list2;

	static {
		DATA = "C:\\Project\\직원출퇴근더미.txt";
		list2 = new ArrayList<EmployeeCommute>();
	}

	public void commuteCheck() {

		load();
		System.out.println("<근태확인>");

		// 2021-01-04■김민수■07:49■18:51■20101010

		/**
		 * 이번달 근무 횟수출력
		 */
		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i).getName().equals(MainClass.logEmployee.getName())) {
				Calendar now = Calendar.getInstance();
				String month = String.format("%02d", now.get(Calendar.MONTH) + 1);
				if (list2.get(i).getCommuteday().substring(5, 7).equals(month)) {
					workday++;

				}
			}
		}

		System.out.printf("총근무일수: %d일\n", workday);

		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i).getName().equals(MainClass.logEmployee.getName())) {
				Calendar now = Calendar.getInstance();
				String month = String.format("%02d", now.get(Calendar.MONTH) + 1);
				if (list2.get(i).getCommuteday().substring(5, 7).equals(month)) {
					if (list2.get(i).getStartTime().substring(1, 2).equals("9")) {
						lateday++;

					}

				}

			}
		}

		System.out.printf("지각 : %d회\n", lateday);

		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i).getName().equals(MainClass.logEmployee.getName())) {
				Calendar now = Calendar.getInstance();
				String month = String.format("%02d", now.get(Calendar.MONTH) + 1);
				if (list2.get(i).getCommuteday().substring(5, 7).equals(month)) {
					int time = Integer.parseInt(list2.get(i).getEndTime().substring(1, 2));
					if (time < 6) {
						earlyleaveday++;

					}

				}

			}
		}

		System.out.printf("조퇴 : %d회\n", earlyleaveday++);

	}

	public void load() {

		try {

			BufferedReader reader = new BufferedReader(new FileReader(DATA));

			String line = "";

			while ((line = reader.readLine()) != null) {

				// 2021-01-04■김민수■07:49■18:51■20101010
				EmployeeCommute employeeCommute = new EmployeeCommute();

				String[] temp = line.split("■");
				employeeCommute.setCommuteDay(temp[0]);
				employeeCommute.setName(temp[1]);
				employeeCommute.setStartTime(temp[2]);
				employeeCommute.setEndTime(temp[3]);

				list2.add(employeeCommute);
			}
			reader.close();

		} catch (Exception e) {
		}
	}
}