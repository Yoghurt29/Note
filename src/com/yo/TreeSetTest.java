package com.yo;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {

	public TreeSetTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Student> ss =new TreeSet<>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		ss.add(new Student("Trulon",25,88,90));
		ss.add(new Student("Nancy",24,90,75));
		ss.add(new Student("Yeoman",21,70,65));
		ss.add(new Student("Tom",25,60,99));
		ss.add(new Student("Jerry",18,98,56));
		for (Student s : ss) {
			System.out.println(s.getName());
		}
	}

}
