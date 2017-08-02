package com.day20170714ListSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
/**
 * JAVA数组具有协变性 
 * 协变性是指 A<= B 则 F(A)<=F(B),其中<=表示继承关系
 * @author Trulon_Chu
 * f(A)=List<Object>，f(B) = List<String>，而两则
 */
public class ListSetTest {

	public ListSetTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void test() {
		String[] ss = {"","s"}; 
		Object[] os; 
		System.out.println(ss instanceof Object[]);
		String s=null;
		System.out.println(s instanceof String);
		List<String> sl=new ArrayList();
		System.out.println(sl instanceof List);
		LinkedList l;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList<>();
		list.add("HELLO");
		String s=new String("HELLO");
		System.out.println(list.contains("HELLO"));
		System.out.println(list.contains(s));

	}

}
