package com.headFirst;

public class TestObserve {

	public TestObserve() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DayDataDiffrence d =new DayDataDiffrence();
		EmailNotify e=new EmailNotify();
		d.addObserver(e);
		d.checkDiffrence();
	}

}
