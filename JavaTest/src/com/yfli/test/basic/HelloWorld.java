package com.yfli.test.basic;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World");
		byte b = 1;
      short s = 200;
      //int i = 300;
      long l = 400;
 
      /*�����ͼ��byte���͵ı������賬���䷶Χ��ֵ���ͻ�����������*/
      byte b2 = 'z';
      int b3 = 'z';
      System.out.println(b3);
      char c = '��';
      //char ֻ�ܴ��һ���ַ�������һ���ַ��ͻ�����������
      //char c2 = '�й�'; //����
      //char c3 = 'ab'; //����
      System.out.println(c);
      
      double d = 123.45;
      
      //���л���ֱ��������Ϊ54.321��double�͵�
      //float f = 54.321;
        
      float f2 = 54.321f;
      
      boolean b1 = true;
      boolean x = false;

      // ��Ȼ������������ŵ�������0(false) 1(true)
      // ���ǣ�����ֱ��ʹ��0 1 ���и�ֵ
      //boolean y = 1;
      
      long val = 26L; //��L��β������ֵ��ʾlong��
      int decVal = 26; //Ĭ�Ͼ���int��
      int hexVal = 0x1a; //16����
      int oxVal = 032; //8����
      int binVal = 0b11010; //2����
      System.out.println(val);
      System.out.println(decVal);
      System.out.println(hexVal);
      System.out.println(oxVal);
      System.out.println(binVal);
      
      int i  =-10;
      
      //-10�Ķ�������11111111111111111111111111110110
      //��һλ��1��������λ����������һ������
      System.out.println(Integer.toBinaryString(i));
       
      //���������� ���������� >> ������е�λ���ƣ�������ǰ�油0
      //���ڸ����� ���������� >> ������е�λ���ƣ�������ǰ�油1
       
      //-10����������1λ���ƶ���ǰ�油��1
      //�õ�11111111111111111111111111111011
      //��Ϊ��һλ��1��������Ȼ��һ����������Ӧ��ʮ������-5
      int j = i>>1;
      System.out.println(Integer.toBinaryString(j));
      System.out.println(j);
       
      //-10�޷���������1λ������λҲ�������ƣ���һλ�ͱ����0
      //�õ�01111111111111111111111111111011����Ӧ��ʮ������2147483643
      int k = i>>>1;
      System.out.println(Integer.toBinaryString(k));     
       
      System.out.println(k);
      
      //int�����ֵ
      System.out.println(Integer.MAX_VALUE);
      //int����Сֵ      
      System.out.println(Integer.MIN_VALUE);
  
	}
	
}
