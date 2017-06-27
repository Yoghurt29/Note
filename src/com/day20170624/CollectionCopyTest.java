package com.day20170624;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionCopyTest {

	public CollectionCopyTest() {
	}

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student[]{new Student("tom"),new Student("jerry")});
		
		List<Student> list1=new ArrayList<>();
		list1.add(new Student("tom"));
		list1.add(new Student("jerry"));
		 List<Student> listNew = new ArrayList<Student>(Arrays.asList(new Student[list1.size()]));  
		Collections.copy(listNew, list1);
		list1.forEach(o->o.setName("5"));
		listNew.forEach(o->System.out.println(o.getName()));
	}

}
