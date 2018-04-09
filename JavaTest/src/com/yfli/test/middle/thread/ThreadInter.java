package com.yfli.test.middle.thread;

import com.yfli.test.middle.lambda.Hero;

public class ThreadInter {
    
    public static void main(String[] args) {
    
        final Hero gareen = new Hero();
        gareen.name = "¸ÇÂ×";
        gareen.hp = 616;
             
        Thread t1 = new Thread(){
            public void run(){
                while(true){
                       
                    //ÎÞÐèÑ­»·ÅÐ¶Ï
//                    while(gareen.hp==1){
//                        continue;
//                    }
                       
                    gareen.hurt();
                     
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
   
            }
        };
        t1.start();
   
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();
   
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
   
            }
        };
        t2.start();
             
    }
          
}
