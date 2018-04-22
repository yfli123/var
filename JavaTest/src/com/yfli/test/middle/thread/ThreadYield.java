package com.yfli.test.middle.thread;

import com.yfli.test.middle.lambda.Hero;

public class ThreadYield {
	  
    public static void main(String[] args) {
          
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 61600;
        gareen.damage = 1;
  
        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 1;
          
        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 50000;
        bh.damage = 1;
          
        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 450;
        leesin.damage = 1;
          
        Thread t1= new Thread(){
            public void run(){
 
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }              
            }
        };
          
        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    //临时暂停，使得t1可以占用CPU资源
                    Thread.yield();
                     
                    bh.attackHero(leesin);
                }              
            }
        };
        
        
        Thread t3= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    //临时暂停，使得t1可以占用CPU资源
                     
                    bh.attackHero(leesin);
                }              
            }
        };
         
        t1.setPriority(5);
        t2.setPriority(5);
        t3.setPriority(4);
        t1.start();
        t2.start();
        t2.start();
          
    }
      
}
