package com.day20170704InnerClass;

import java.io.File;
import java.lang.reflect.Field;

/**
 * 多重继承的替代方案，内部类
 * final字段反射修改无效，也不报错
 */
import com.day20170704InnerClass.InnerClassTest.InnerClass;

public class InnerClassTest {
	private final String name="hi";
	private File f=new File("");
	private int age;
	public InnerClassTest() {
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		InnerClassTest it=new InnerClassTest();
		it.reflect();
		System.out.println(it.getName());
		InnerClass iti=new InnerClassTest().new InnerClass();
		it.setAge(987);
		iti.hello();
		System.out.println(it.getAge());
		String name2 = it.getName();
		name2=new String("aaaa");
		System.out.println(it.getName());
	}

	public class InnerClass{
		private String iName;
		public void hello() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
			System.out.println(name);

			System.out.println(getName());
			f=new File("");
			System.out.println(InnerClassTest.this.getAge());
		}
	}
	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public void reflect() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field field = this.getClass().getDeclaredField("name");
		field.setAccessible(true);
		field.set(this, "cc");
	}

}
