package com.yfli.test.middle.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
   
public class LambdaInObject {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("��ʼ����ļ��ϣ�");
        System.out.println(heros);
     
        System.out.println("ʹ�����ö��󷽷�  �Ĺ��˽����");
        //ʹ����Ķ��󷽷�
        LambdaInObject testLambda = new LambdaInObject();
        filter(heros, testLambda::testHero);
    }
     
    public boolean testHero(Hero h) {
        return h.hp>100 && h.damage<50;
    }
     
    private static void filter(List<Hero> heros, HeroChecker checker) {
        for (Hero hero : heros) {
            if (checker.test(hero))
                System.out.print(hero);
        }
    }
 
}