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
        System.out.println("初始化后的集合：");
        System.out.println(heros);
     
        System.out.println("使用引用对象方法  的过滤结果：");
        //使用类的对象方法
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
