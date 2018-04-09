package com.yfli.test.middle.thread;

import com.yfli.test.middle.lambda.Hero;

public class ThreadPriorty {
	  
    public static void main(String[] args) {
          
        final Hero gareen = new Hero();
        gareen.name = "¸ÇÂ×";
        gareen.hp = 6160;
        gareen.damage = 1;
  
        final Hero teemo = new Hero();
        teemo.name = "ÌáÄª";
        teemo.hp = 3000;
        teemo.damage = 1;
          
        final Hero bh = new Hero();
        bh.name = "ÉÍ½ðÁÔÈË";
        bh.hp = 5000;
        bh.damage = 1;
          
        final Hero leesin = new Hero();
        leesin.name = "Ã¤É®";
        leesin.hp = 4000;
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
                    bh.attackHero(leesin);
                }              
            }
        };
         
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
          
    }
      
}
