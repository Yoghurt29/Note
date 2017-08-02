package com.day20170720Extends;
/**
 * 多态
 * 方法调用时动态绑定的，在具体调用方法是确定
 * @author Trulon_Chu
 *
 */
public class ExtendsTest {

	public ExtendsTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Object s=new String("xxxx");
		Object s2=new Object();
		System.out.println(s.toString());
		System.out.println(s2.toString());
	}

}
