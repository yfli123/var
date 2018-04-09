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
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
                     
                }              
            }
        };
        //t1.setDaemon(true);//守护线程，如果进程中都是守护线程，则该进程直接结束
        t1.start();
          
    }
      
}
