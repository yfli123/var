package com.yfli.test.middle.thread;

import com.yfli.test.middle.lambda.Hero;

public class MultiThreadRunnable {
	 
    public static void main(String[] args) {
         
        Hero gareen = new Hero();
        gareen.name = "¸ÇÂ×";
        gareen.hp = 616;
        gareen.damage = 50;
 
        Hero teemo = new Hero();
        teemo.name = "ÌáÄª";
        teemo.hp = 300;
        teemo.damage = 30;
         
        Hero bh = new Hero();
        bh.name = "ÉÍ½ğÁÔÈË";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "Ã¤É®";
        leesin.hp = 455;
        leesin.damage = 80;
         
        Battle battle1 = new Battle(gareen,teemo);
         
        new Thread(battle1).start();
 
        Battle battle2 = new Battle(bh,leesin);
        new Thread(battle2).start();
        
        Battle battle3 = new Battle(leesin,bh);
        new Thread(battle3).start();
        
        
        Battle battle4 = new Battle(teemo,gareen);
        
        new Thread(battle4).start();
 
    }
     
}
