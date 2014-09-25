package com.test2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTest {
	/**
	 * 待发送webservice消息队列
	 */
	static  BlockingQueue<String> queue=new LinkedBlockingQueue<String>();
	
	public static void main(String[] args) {
		
		Runnable runnable1=new Runnable() {
			public void run() {
				try {
					for(int i=0;i<1000;i++){
						queue.put("aaa"+i);
						Thread.sleep(100);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable runnable2=new Runnable() {
			public void run() {
				try {
					for(int i=0;i<1000;i++){
						queue.put("bbb"+i);
						Thread.sleep(100);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable runnable3=new Runnable() {
			public void run() {
				try {
					while(true){
						if(queue.isEmpty()){
							Thread.sleep(1000);
						}else{
							System.out.print(queue.take()+"\n");
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		for(int i=0;i<10;i++){
			Thread puThread=new Thread(runnable1);
			Thread putThread=new Thread(runnable2);
			
			
			puThread.start();
			putThread.start();
			
		}
		Thread takeThread=new Thread(runnable3);
		takeThread.start();
		
	}
	
}
