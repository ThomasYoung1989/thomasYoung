package com.test2;

public class LockTest {
	
	private Object object=new Object();
	
	public void test(){
		Thread thread1=new Thread(new Runtest("thread1"));
		Thread thread2=new Thread(new Runtest("thread2"));
		
		thread1.start();
		thread2.start();
	}
	
	public static void main(String[] args) {
		LockTest lockTest=new LockTest();
		lockTest.test();
	}
	
	
	
	class Runtest implements Runnable{
		
		private String name;
		
		
		
		public Runtest(String name) {
			super();
			this.name = name;
		}



		public void run() {
			synchronized (object) {
				System.out.print("thread "+name+" is running!");
				try {
					Thread.currentThread().sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
