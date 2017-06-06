package com.java8;

public class TreadTest {

	public TreadTest() {
		// TODO Auto-generated constructor stub
	}

	public static void testDeadLock(){
		ThreadProduct p=new ThreadProduct();
		Object lock1=new Object();
		Object lock2=new Object();
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					p.deadLock(lock1, lock2,false);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		},"T1");
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					p.deadLock(lock1, lock2,true);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		},"T2");
		Thread t3=new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					p.deadLock(lock1, lock2,false);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		},"T3");
		t2.start();
		t1.start();
		//t3.start();
	}
	/**
	 * 同步
	 */
	public static void testSynchronized(){
		ThreadProduct p=new ThreadProduct();
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					p.produce();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		},"廚師");
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					p.consumer();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		},"顧客1");
		Thread t3=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					p.consumer();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		},"顧客2");
		
		t2.start();
		t1.start();
		t3.start();
	}
	public static void main(String[] args) {
		testDeadLock();
	}
}
