package com.day20170719ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 只要任务未执行完，核心线程似乎都是存活的
 * 
 * @author Trulon_Chu
 *
 */
public class ThreadPoolExecutorTest {
	static List<Integer> numbers = new ArrayList<>();
	static Integer count = 0;
	static Object lockKnife=new Object();
	static Object lockFork=new Object();
	volatile static boolean flag=true;
	public ThreadPoolExecutorTest() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 相互持有对方所需资源导致死锁
	 * 在资源使用上采用一致的加锁顺序，避免死锁
	 * @param lockKnife
	 * @param lockFork
	 */
	public static void eat(Object lockKnife,Object lockFork){
		if(flag){
			synchronized (lockKnife) {
				flag=false;
				String name = Thread.currentThread().getName();
				System.out.println(name+"拿着刀子，还差叉子");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lockFork) {
					System.out.println(name+"拿着叉子+刀子，吃");
				}
			}
		}else{
			synchronized (lockFork) {
				flag=true;
				String name = Thread.currentThread().getName();
				System.out.println(name+"拿着叉子，还差刀子");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lockKnife) {
					System.out.println(name+"拿着叉子+刀子，吃");
				}
			}
		}
	}
	/**
	 * 线程池简易使用
	 * 	大量线程产生时按队列调度执行，避免卡死
	 */
	public static void Test2() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				eat(lockKnife,lockFork);
			}
		}, "TOM").start();

		ThreadPoolExecutor tpe = new ThreadPoolExecutor(20, 200, 2, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(20));
		for (int i = 0; i < 20; i++) {
			tpe.execute(new Thread(new Runnable() {
				@Override
				public void run() {
					eat(lockKnife,lockFork);
				}
			}, "Custom"+i));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void Test1() {
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 200, 1, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(1));
		for (int i = 0; i < 200; i++) {
			tpe.execute(new Thread(new Runnable() {

				@Override
				public void run() {
					countPlus();
				}
			}, "Thread" + i));
			/*try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		tpe.execute(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println(count);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public static synchronized void countPlus() {
		count++;
		System.out.println(Thread.currentThread().getName());

	}
	public static void main(String[] args) {
	}

}
