package com.question;

public class Hibernate {
	String q1="from tuple";
	/*
	 * 	 	could not instantiate class [com.yo.entities.User] from tuple]
		 	实体类字段应该使用包装类型，数据库的null值才能正确封装
	 */
	String q2="持久化顺序";
	/*
	 * 元素先持久化，还是元素的子属性集合中的对象先持久化顺序是不确定的——传播性持久化
	 * 
	 */
	String q3="使用迭代方法orList方法";
	/*
	 * 在有缓存的情形下可以更快，发送一条选出所有id，在拿着id去查询，缓存中无，则每个发送一条
	 * 
	 */
	String q4="<![CDATA[]]>";
	/*
	 * 
	 * 
	 */
}
