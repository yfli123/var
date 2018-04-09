package com.yfli.test.middle.thread;

import com.yfli.test.middle.lambda.Hero;

public class Battle implements Runnable{
    
    private Hero h1;
    private Hero h2;
 
    public Battle(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
 
    public void run(){
        while(!h2.isDead() && !h1.isDead()){
            h1.attackHero(h2);
        }
    }
}