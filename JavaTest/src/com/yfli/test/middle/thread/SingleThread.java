package com.yfli.test.middle.thread;

import com.yfli.test.middle.lambda.Hero;

public class SingleThread {
	 
    public static void main(String[] args) {
         
        Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 616;
        gareen.damage = 50;
 
        Hero teemo = new Hero();
        teemo.name = "��Ī";
        teemo.hp = 300;
        teemo.damage = 30;
         
        Hero bh = new Hero();
        bh.name = "�ͽ�����";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "äɮ";
        leesin.hp = 455;
        leesin.damage = 80;
         
        //���׹�����Ī
        while(!teemo.isDead()){
            gareen.attackHero(teemo);
        }
 
        //�ͽ����˹���äɮ
        while(!leesin.isDead()){
            bh.attackHero(leesin);
        }
    }
     
}
