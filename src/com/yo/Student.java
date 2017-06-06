package com.yo;

public class Student {
	private String name;
	private int age;
	private int mathScore;
	private int englishScore;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public int getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}
	public Student(String name, int age, int mathScore, int englishScore) {
		super();
		this.name = name;
		this.age = age;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
	}
	
}
