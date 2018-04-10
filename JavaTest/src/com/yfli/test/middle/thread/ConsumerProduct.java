package com.yfli.test.middle.thread;

import java.util.ArrayList;

/**
 * �����ߺ�������ģʽ����������ַ����뵽��ǰջ�У�Ȼ�󵯳���ʹ�ö��߳�ʵ�֣�Ҫ���̰߳�ȫ
 * @author suxin
 *
 */
public class ConsumerProduct {
	public static void main(String[] args) {
		MyStackThread demoStack = new MyStackThread();
		
		ArrayList<Producer> ps = new ArrayList<>();
		ArrayList<Consumer> cs = new ArrayList<>();
		//����������
		for (int i = 0; i < 2; i++) {
			new Producer(demoStack).start();
		}
		//����������
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
						System.out.println("��ǰѹ���Ԫ����:"+str.charAt(index));
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
						System.out.println("��ǰ������Ԫ���ǣ�"+myStack.pull());
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
