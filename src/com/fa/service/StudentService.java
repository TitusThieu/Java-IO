package com.fa.service;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.fa.dao.StudentDao;
import com.fa.entity.Student;

/**
 * THis class to perform bussiness logic funtion
 */
public class StudentService {
	private StudentDao studentDao;

	public StudentService() {
		studentDao = new StudentDao();
	}

	/**
	 * create new student by enter from keyboard after that store data
	 */
	public void inputStudent() {
		Scanner sc = new Scanner(System.in);
		Student student = new Student();

		System.out.println("enter the id:");
		student.setId(sc.nextInt());

		System.out.println("enter the name:");
		student.setName(sc.next());

		System.out.println("enter the age:");
		student.setAge(sc.nextInt());

		studentDao.save(student);
	}

	/**
	 * display all student with order by name
	 */
	public void displayAllStudentByName() {
		List<Student> allStudent = studentDao.getAllStudentFromFile();
		allStudent.sort(Comparator.comparing(Student::getName));
		for (Student student : allStudent) {
			System.out.println(student.toString());
		}
	}
}
