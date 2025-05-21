package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
	
	private static List<Student> studentList;
	
	public static void main(String[] args) {
		System.out.println("******************Student Management System******************");
		System.out.println("***********Welcome***********");
		
		studentList = new ArrayList<Student>();
		
		
		Student s1;
		s1= new Student("Kajal Kumari",19,"S-21");
		s1.enrollCourse("Java");
		


		//System.out.println(s1); -> To print in one line using toString() method
		//System.out.println(s1); -> com.studentapp.Student@6d06d69c (Hashcode of object s1)
		//s1.printStudentInfo();
		
		Student s2 = new Student("Uday",23,"S-23");
		s2.enrollCourse("DSA");
		
		
		Student s3 = new Student("Monika",21,"S-20");
		s3.enrollCourse("Devops");
		
		Student s4 = new Student("Ajinkya",22,"S-24");
		s4.enrollCourse("Devops");
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);

		
		Student result = findStudentById("S-22");
		System.out.println("Results : "+ result);
		
		sortByName();
		
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
		//Using Lambda expression
		Comparator<Student> studentNameComparator = (o1,o2)->o1.getName().compareTo(o2.getName()); 
			
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
		
	}

	public static Student findStudentById(String studentId) {
		Student result = null; //explicit initialization of local variable result
		try {
		 result = studentList
				.stream()
				.filter(x ->x.getStudentId().equalsIgnoreCase(studentId))
				.findFirst()
		        .orElseThrow(()-> new RuntimeException("No Data found!!!"));
		}
		catch(RuntimeException e) {
			System.err.println("Student with ID "+studentId+" not found!!");
		}
		return result;
	}
}
