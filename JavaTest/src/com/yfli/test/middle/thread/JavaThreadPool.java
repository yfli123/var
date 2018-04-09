package com.yfli.test.middle.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
   
public class JavaThreadPool {
   
    public static void main(String[] args) throws InterruptedException {
           
      /*
       *��һ������10 ��ʾ����̳߳س�ʼ����10���߳������湤��
    	�ڶ�������15 ��ʾ���10���̲߳������ˣ��ͻ��Զ����ӵ����15���߳�
    	����������60 ��ϵ��ĸ�����TimeUnit.SECONDS����ʾ����60�룬��������̻߳�û�нӵ�������ͻ���գ���󱣳ֳ������10��
    	���ĸ�����TimeUnit.SECONDS ����
    	��������� new LinkedBlockingQueue() ����������ļ���
    	*/
    	
        ThreadPoolExecutor threadPool= new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
           
        threadPool.execute(new Runnable(){
   
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("����1");
            }
               
        });
   
    }
   
}
