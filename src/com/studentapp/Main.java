package com.studentapp;

public class Main {

	public static void main(String[] args) {
		System.out.println("******************Student Management System******************");
		System.out.println("***********Welcome***********");
		
		Student s1;
		s1= new Student("Kajal Kumari",19,"S-21");
		s1.enrollCourse("Java");
		s1.printStudentInfo();


		//System.out.println(s1); -> To print in one line using toString() method
		//System.out.println(s1); -> com.studentapp.Student@6d06d69c (Hashcode of object s1)
		//s1.printStudentInfo();
		
		Student s2 = new Student("Uday",23,"S-23");
		s2.enrollCourse("DSA");
		s2.printStudentInfo();
		
		Student s3 = new Student("Monika",21,"S-20");
		s3.enrollCourse("Devops");
		s3.printStudentInfo();
		
	}
}
