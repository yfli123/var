package com.yfli.test.middle.thread;

import java.util.ArrayList;

/**
 * 消费者和生产者模式，产生随机字符插入到当前栈中，然后弹出，使用多线程实现，要有线程安全
 * @author suxin
 *
 */
public class ConsumerProduct {
	public static void main(String[] args) {
		MyStackThread demoStack = new MyStackThread();
		
		ArrayList<Producer> ps = new ArrayList<>();
		ArrayList<Consumer> cs = new ArrayList<>();
		//两个生产者
		for (int i = 0; i < 2; i++) {
			new Producer(demoStack).start();
		}
		//三个消费者
		for (int i = 0; i < 3; i++) {
			new Consumer(demoStack).start();
		}
	}
}

class Producer extends Thread{
	public MyStackThread myStack;
	
	public Producer(MyStackThread myStack) {
		this.myStack = myStack;
	}

	String str = "ABCDEFGHIJKLMN";
	
	@Override
	public void run() {
		
		while (true) {
			synchronized(myStack) {
				if(MyStackThread.length()>2000) {
					System.out.println(MyStackThread.length());
					try {
						//Thread.sleep(1, NORM_PRIORITY);
						//Thread.sleep(1,n);
						/*wait();*/
						myStack.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
						System.out.println(MyStackThread.length());
						int index = (int) (Math.random()*(str.length()));
						System.out.println("当前压入的元素是:"+str.charAt(index));
						myStack.push(str.charAt(index));
					/*try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					myStack.notify();
				}
			}
		}
	}
}

class Consumer extends Thread{
	public MyStackThread myStack;
	
	public Consumer(MyStackThread myStack) {
		this.myStack = myStack;
	}
	
	//String str = "ABCDEFGHIJKLMN";
	@Override
	public void run() {
		
		while(true) {
			synchronized(myStack) {
				if(MyStackThread.length()<=0) {
					try {
						myStack.wait();
						//Thread.sleep(1, NORM_PRIORITY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
						System.out.println("当前弹出的元素是："+myStack.pull());
					/*try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					myStack.notify();
				}
			}
		}
		
	}
	
	
}
