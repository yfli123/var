package com.yfli.test.middle.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
 
 
public class LambdaAggregateArray {
 
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        //�ܵ�Դ�Ǽ���
        heros
        .stream()
        .forEach(h->System.out.println(h.name));
         
        //�ܵ�Դ������
        Hero hs[] = heros.toArray(new Hero[heros.size()]);
        Arrays.stream(hs)
        .forEach(h->System.out.println(h.name));
         
    }
}
