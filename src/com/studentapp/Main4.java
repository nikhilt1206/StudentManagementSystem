package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main4 {

	private static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("******************Student Management System******************");

		studentList = new ArrayList<Student>();

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("***********Welcome***********");

			System.out.println("Select an option...");
			System.out.println("1. Register a student");
			System.out.println("2. Find Student with studentID");
			System.out.println("3. List all Student information");
			System.out.println("4. List Student information in sorted order");
			System.out.println("5. Exit");

			int option = scanner.nextInt();
			switch (option) {
			case 1:
				enrollStudent(scanner);
				break;
			case 2:
				findStudentById(scanner);
				break;
			case 3:
				printAllStudentData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Invalid option selected!....Enter options between 1 to 5");
			}

		}
	}

	private static void exit() {
		System.out.println("Good Bye!!");
		System.exit(0);

	}

	private static void printAllStudentData() {
		 
		if(studentList.size()>0) {
		System.out.println("---------------PRINTING all student data--------------");
		for (Student student : studentList) {
			student.printStudentInfo();
		}
		System.out.println("---------------*************************--------------");
		}
		else {
			System.err.println("Student list is empty!! No student record found!!");
		}
	}

	private static void findStudentById(Scanner scanner2) {
		
		Student studentFound = null; //explicit initialization of local variable result
		System.out.println("Enter the Student ID");
		String studentId=scanner2.next();
		
		try {
			studentFound = studentList
				.stream()
				.filter(student ->student.getStudentId().equalsIgnoreCase(studentId))
				.findFirst()
		        .orElseThrow(()-> new RuntimeException("No Data found!!!"));
		}
		catch(RuntimeException e) {
			System.err.println("Student with ID "+studentId+" not found!!");
		}
		studentFound.printStudentInfo();
	}



	private static void enrollStudent(Scanner scanner2) {

		System.out.println("Enter Student name");
		String studentName = scanner2.next();

		System.out.println("Enter Student age");
		int studentAge = scanner2.nextInt();

		System.out.println("Enter Student ID");
		String studentId = scanner2.next();

		Student newStudent = new Student(studentName, studentAge, studentId);
		studentList.add(newStudent);
		// System.out.println("Student added successfully into the LMS");
		while (true) {
			System.out.println("Enter the course to be enrolled!!...Type done to exit");
			String courseName = scanner2.next();
			if (courseName.equalsIgnoreCase("done")) {
				break;
			}
			newStudent.enrollCourse(courseName);

		}
		newStudent.printStudentInfo();
	}

	private static void sortByName() {

//		Comparator<Student> studentNameComparator = new Comparator<Student>() {
//			
////			@Override
////			public int compare(Student o1, Student o2) {
////				
////				return o1.getName().compareTo(o2.getName()); //it will compare alphabetically.
////			}
//		};
		// Using Lambda expression
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

		Collections.sort(studentList, studentNameComparator);
		//System.out.println(studentList);
		printAllStudentData();
	}

	public static Student findStudentById(String studentId) {
		Student result = null; // explicit initialization of local variable result
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data found!!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found!!");
		}
		return result;
	}
}
