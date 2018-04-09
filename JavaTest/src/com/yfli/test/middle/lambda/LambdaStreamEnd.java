package com.yfli.test.middle.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
 
  
public class LambdaStreamEnd {
  
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("���������е�ÿ������");
        heros
            .stream()
            .forEach(h->System.out.print(h));
        System.out.println("����һ������");
        Object[] hs= heros
            .stream()
            .toArray();
        System.out.println(Arrays.toString(hs));
        System.out.println("�����˺���͵��Ǹ�Ӣ��");
        Hero minDamageHero =
        heros
            .stream()
            .min((h1,h2)->h1.damage-h2.damage)
            .get();
        System.out.print(minDamageHero);
        System.out.println("�����˺���ߵ��Ǹ�Ӣ��");
 
        Hero mxnDamageHero =
                heros
                .stream()
                .max((h1,h2)->h1.damage-h2.damage)
                .get();
        System.out.print(mxnDamageHero);     
         
        System.out.println("�������ݵ�����");
        long count = heros
                .stream()
                .count();
        System.out.println(count);
 
        System.out.println("��һ��Ӣ��");
        Hero firstHero =
                heros
                .stream()
                .findFirst()
                .get();
         
        System.out.println(firstHero);
         
    }
}
