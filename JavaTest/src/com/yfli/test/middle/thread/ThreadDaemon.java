package com.yfli.test.middle.thread;

public class ThreadDaemon {
	  
    public static void main(String[] args) {
          
        Thread t1= new Thread(){
            public void run(){
                int seconds =0;
                 
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("�Ѿ�����LOL %d ��%n", seconds++);
                     
                }              
            }
        };
        //t1.setDaemon(true);//�ػ��̣߳���������ж����ػ��̣߳���ý���ֱ�ӽ���
        t1.start();
          
    }
      
}
