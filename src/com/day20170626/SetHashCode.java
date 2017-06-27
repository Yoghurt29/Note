package com.day20170626;

import java.util.HashSet;
/**
 * 
 * @author Trulon_Chu
 *
 */
public class SetHashCode {

	public SetHashCode() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		HashSet<Student> ss=new HashSet<>();
		Student s1=new Student("tom");
		Student s2=new Student("jerry");
		ss.add(s1);
		ss.add(s2);
		s2.setName("a");
		System.out.println(ss.contains(s1));
		System.out.println(ss.contains(s2));
		System.out.println(ss.size());
		/*System.out.println("*--------------------------------------*");
		for (Student student : ss) {
			System.out.println("*-----*");
			System.out.println(student.getName());
			System.out.println(student==s1);
			System.out.println(student==s2);
		}*/
		
	}

}
