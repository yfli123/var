package com.yfli.test.middle.thread;

import com.yfli.test.middle.lambda.Hero;

public class ThreadPriorty {
	  
    public static void main(String[] args) {
          
        final Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 6160;
        gareen.damage = 1;
  
        final Hero teemo = new Hero();
        teemo.name = "��Ī";
        teemo.hp = 3000;
        teemo.damage = 1;
          
        final Hero bh = new Hero();
        bh.name = "�ͽ�����";
        bh.hp = 5000;
        bh.damage = 1;
          
        final Hero leesin = new Hero();
        leesin.name = "äɮ";
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
