package com.yfli.test.middle.thread;

public class SkillCharge {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				int count = 1;
				while(true) {
					
					if(count == 4) {
						System.out.println("��ʼ5����ܣ�");
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						count = 1;
					}else {
						System.out.println("����ȭ��"+count+"����");
						try {
							Thread.sleep(1000);
							count++;
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			}
		};
		t1.start();
	}
}
