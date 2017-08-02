package com.day20170719Finally;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
/**
 * finally 中对于返回值的更改类似于对final修饰的变量的更改，
 * 返回值在catch时已经被拷贝到栈顶准备返回了！
 * 因此对于常量修改无用，对于引用类型修改指向无用。
 * 修改引用类型指向对象的属性自然有用。
 * 因为返回的只是个引用，最终通过引用找到的对象还是被修改了。
 * 
 * 在finally块中返回，将会更新栈顶的返回值，自然所做的任何修改均有用。
 * 但编译器似乎不建议在finally中有返回语句。
 * @author Trulon_Chu
 *
 */
public class FinallyReturnTest {

	public FinallyReturnTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println(getDate());
		System.out.println(getInt());
		funCantThrowExctption();
	}
	public static Date getDate(){
		Date d=new Date();
		try {
			int a=5/0;
		} catch (Exception e) {
			return d;	
		}finally {
			d.setYear(25);
			d=null;
			return d;
		}
	}
	public static int getInt(){
		int d=5;
		try {
			int a=5/0;
		} catch (Exception e) {
			return d;	
		}finally {
			d=8;
			return d;
		}
	}
	/**
	 * 异常的包装转换
	 * @throws FileNotFoundException 
	 */
	public static void funThrowCheckedException() throws FileNotFoundException{
		File f=new File("");
		FileInputStream fi=new FileInputStream(f);
	}
	public static void funCantThrowExctption(){
		try {
			funThrowCheckedException();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
