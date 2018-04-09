package com.yfli.test.basic;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World");
		byte b = 1;
      short s = 200;
      //int i = 300;
      long l = 400;
 
      /*如果试图给byte类型的变量赋予超出其范围的值，就会产生编译错误*/
      byte b2 = 'z';
      int b3 = 'z';
      System.out.println(b3);
      char c = '中';
      //char 只能存放一个字符，超过一个字符就会产生编译错误
      //char c2 = '中国'; //报错
      //char c3 = 'ab'; //报错
      System.out.println(c);
      
      double d = 123.45;
      
      //该行会出现编译错误，因为54.321是double型的
      //float f = 54.321;
        
      float f2 = 54.321f;
      
      boolean b1 = true;
      boolean x = false;

      // 虽然布尔型真正存放的数据是0(false) 1(true)
      // 但是，不能直接使用0 1 进行赋值
      //boolean y = 1;
      
      long val = 26L; //以L结尾的字面值表示long型
      int decVal = 26; //默认就是int型
      int hexVal = 0x1a; //16进制
      int oxVal = 032; //8进制
      int binVal = 0b11010; //2进制
      System.out.println(val);
      System.out.println(decVal);
      System.out.println(hexVal);
      System.out.println(oxVal);
      System.out.println(binVal);
      
      int i  =-10;
      
      //-10的二进制是11111111111111111111111111110110
      //第一位是1，即符号位，代表这是一个负数
      System.out.println(Integer.toBinaryString(i));
       
      //对于正数， 带符号右移 >> 会把所有的位右移，并在最前面补0
      //对于负数， 带符号右移 >> 会把所有的位右移，并在最前面补1
       
      //-10带符号右移1位，移动后前面补齐1
      //得到11111111111111111111111111111011
      //因为第一位是1，所以依然是一个负数，对应的十进制是-5
      int j = i>>1;
      System.out.println(Integer.toBinaryString(j));
      System.out.println(j);
       
      //-10无符号向右移1位，符号位也会向右移，第一位就变成了0
      //得到01111111111111111111111111111011，对应的十进制是2147483643
      int k = i>>>1;
      System.out.println(Integer.toBinaryString(k));     
       
      System.out.println(k);
      
      //int的最大值
      System.out.println(Integer.MAX_VALUE);
      //int的最小值      
      System.out.println(Integer.MIN_VALUE);
  
	}
	
}
