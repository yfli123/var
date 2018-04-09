package com.yfli.test.middle.thread;

import com.yfli.test.middle.lambda.Hero;

public class ThreadSafeExample {
    
    public static void main(String[] args) {
            
        final Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 10000;
           
        System.out.printf("���׵ĳ�ʼѪ���� %.0f%n", gareen.hp);
           
        //���߳�ͬ������ָ���Ƕ���߳�ͬʱ�޸�һ�����ݵ�ʱ�򣬵��µ�����
           
        //���������10000��Ѫ�������ڻ����ͬʱ�ֱ��Է����Ӣ�۹���
           
        //��JAVA��������ʾ�������ж���߳��ڼ��ٸ��׵�hp
        //ͬʱ���ж���߳��ڻָ����׵�hp
           
        //n���߳����Ӹ��׵�hp
           
        int n = 10000;
   
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];
           
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                	synchronized (gareen) {
                		gareen.recover();
                	}
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
               
        }
           
        //n���̼߳��ٸ��׵�hp
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                	synchronized (gareen) {
                		gareen.hurt();
                	}
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }
           
        //�ȴ����������߳̽���
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //�ȴ����м����߳̽���
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
           
        //����ִ�е�����������Ӻͼ����̶߳�������
           
        //���Ӻͼ����̵߳�������һ���ģ�ÿ�ζ����ӣ�����1.
        //��ô�����̶߳������󣬸��׵�hpӦ�û��ǳ�ʼֵ
           
        //������ʵ�Ϲ۲쵽���ǣ�
                   
        System.out.printf("%d�������̺߳�%d�������߳̽�����%n���׵�Ѫ������� %.0f%n", n,n,gareen.hp);
           
    }
        
}
