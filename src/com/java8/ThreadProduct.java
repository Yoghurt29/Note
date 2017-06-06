package com.java8;

public class ThreadProduct {
	private int max=30;
	private int productCount=1;
	public ThreadProduct() {
		// TODO Auto-generated constructor stub
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	/**
	 * 同步，單個方法同一時刻只有一個線程執行
	 * 同一個對象的同步方法使用同一個鎖——對象本身
	 */
	public synchronized void produce(){
			if(productCount<max){
				productCount++;
				System.out.println(Thread.currentThread().getName()+"：包子生產了，現有"+productCount);
			}else{
				System.out.println(Thread.currentThread().getName()+"：包子滿了"+productCount);
			}

	}
	public synchronized void consumer(){
		if(productCount>0){
			productCount--;
			System.out.println(Thread.currentThread().getName()+"：包子消費了，現有"+productCount);
		}else{
			System.out.println(Thread.currentThread().getName()+"：包子沒了，現有"+productCount);
		}	
	}
	/**
	 * 死鎖的控制，使用一個flag來分別讓不同線程走不通路徑，以實現各自所需的鎖被對方持有，而出現死鎖
	 * 
	 * 加鎖順序不一致出現了死鎖，
	 * 加鎖順序一致不出現死鎖
	 * 
	 *【强制】对多个资源、数据库表、对象同时加锁时，需要保持一致的加锁顺序，否则可能会造成死锁。 说明：线程一需要对表A、B、C依次全部加锁后才可以进行更新操作，那么线程二的加锁顺序也必须是A、B、C，否则可能出现死锁。
	 */
	public void deadLock(Object lock1,Object lock2,boolean flag){
		if(flag)synchronized(lock1){
			System.out.println(Thread.currentThread().getName()+"正在執行lock1");
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(lock2){
				System.out.println(Thread.currentThread().getName()+"正在執行lock2");
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(!flag)synchronized(lock2){
			System.out.println(Thread.currentThread().getName()+"正在執行lock2");
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(lock1){
				System.out.println(Thread.currentThread().getName()+"正在執行lock1");
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
