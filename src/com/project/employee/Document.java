package com.project.employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import com.project.MainClass;

public class Document {

	private static Scanner scan;

	private final static String DATA;
	private final static String DATA2;

	static {
		scan = new Scanner(System.in);
		DATA = "C:\\Project\\직원서류서명더미.txt";
		DATA2 = "C:\\Project\\직원서류서명더미2.txt";
		
	}

	public void document() {

		System.out.println("===================");
		System.out.println("1. 근태서류");
		System.out.println("===================");
		System.out.print("번호 입력(0: 뒤로가기): ");
		String sel = scan.nextLine();

		boolean loop = true;

		while (loop) {

			if (sel.equals("1")) {
				System.out.println("목록보기");
				// System.out.printf("%s로그인 완료\n", MainClass.logEmployee.getName());
				sign();
				System.out.print("서류의 내용이 맞으면 이름을 적어주세요: ");
				String singname = scan.nextLine();
				if (singname.equals(MainClass.logEmployee.getName())) {
					save();
				}

				break;
			} else {
				loop = false;
			}
		}

	}

	private void save() {

		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DATA));
			BufferedWriter writer = new BufferedWriter(new FileWriter(DATA2));
			
			String line = "";

			while ((line = reader.readLine()) != null) {

				// 구대혁■지각■2021-05-07

				String[] temp = line.split("■");

				if (!temp[0].equals(MainClass.logEmployee.getName())) {
					writer.write(String.format("%s\t%s\t%s\n", temp[0], temp[1], temp[2]));
				}

			}
			writer.close();
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void sign() {

		try {

			BufferedReader reader = new BufferedReader(new FileReader(DATA));

			String line = "";

			int i = 1;
			while ((line = reader.readLine()) != null) {

				// 1■유민우■지각■2021-05-03■20198974

				String[] temp = line.split("■");

				if (temp[0].equals(MainClass.logEmployee.getName())) {
					System.out.printf("%d%s\t%s\t%s\n", i, temp[0], temp[1], temp[2]);
					i++;
				}

			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
