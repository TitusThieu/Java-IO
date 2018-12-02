package com.fa.ui;

import java.util.Scanner;

import com.fa.service.StudentService;

public class App {
	private StudentService studentService;

	public App() {
		studentService = new StudentService();
	}

	public static void main(String[] args) {
		App appTest = new App();
		Scanner sc = new Scanner(System.in);
		byte select;
		do {
			System.out.println("1.Input new student");
			System.out.println("2.Display student sorted by name");
			System.out.println("3.Exit program!");
			select = sc.nextByte();
			switch (select) {
			case 1:
				appTest.studentService.inputStudent();
				break;
			case 2:
				appTest.studentService.displayAllStudentByName();
				break;
			default:
				break;
			}
		} while (select >= 1 && select <= 3);
	}
}
