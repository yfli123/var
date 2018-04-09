package com.yfli.test.middle.coll;

import java.util.HashSet;

public class CollHashSet {
    public static void main(String[] args) {
 
        String[] ss = new String[100];
        // ��ʼ��
        for (int i = 0; i < ss.length; i++) {
            ss[i] = randomString(2);
        }
        // ��ӡ
        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i] + " ");
            if (19 == i % 20)
                System.out.println();
        }
 
        HashSet<String> result = new HashSet<>();
 
        for (String s1 : ss) {
            int repeat = 0;
            for (String s2 : ss) {
                if (s1.equalsIgnoreCase(s2)) {
                    repeat++;
                    if (2 == repeat) {
                        // ��repeat==2��ʱ�򣬾��ҵ���һ���Ǽ����ظ��ַ���
                        result.add(s2);
                        break;
                    }
                }
            }
        }
 
        System.out.printf("�ܹ��� %d���ظ����ַ���%n", result.size());
        if (result.size() != 0) {
            System.out.println("�ֱ��ǣ�");
            for (String s : result) {
                System.out.print(s + " ");
            }
        }
    }
 
    private static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }
}
