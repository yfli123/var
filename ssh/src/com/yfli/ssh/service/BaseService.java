package com.yfli.ssh.service;

import java.util.List;

import com.yfli.ssh.util.Page;

/* ����������һ�����⣬BaseServiceImpl��������һ��
 
Class clazz =Category.class;
 

��ʾ���BaseServiceImpl��ר�����ڽ���Category���CURD�ģ�����Ǻ���Ҫ���Ĳ�Ʒ���ܶ�Ӧ��ProductService�̳�BaseServiceImpl ����࣬��������������

���������ô����أ� �����������������������������Ƚϸ��ӣ������¼����������
1. ����clazz��ʱ�򣬲���ָ��Category.class ����
 
protected Class clazz;
 


2. �ڹ��췽���У������쳣����ͷ���õ�Category.class����Product.class�� ��Ҫ�����ĸ���̳���BaseServiceImpl��clazz �Ͷ�Ӧ�ĸ������
������ CategoryServiceImpl�̳���BaseServiceImpl,��ô���clazz��ֵ����Category.class
������ ProductServiceImpl�̳���BaseServiceImpl,��ô���clazz��ֵ����Product.class

 
public BaseServiceImpl(){
	try{
		throw new Exception();	
	}
	catch(Exception e){
		StackTraceElement stes[]= e.getStackTrace();
	    String serviceImpleClassName=	stes[1].getClassName();
	    try {
			Class  serviceImplClazz= Class.forName(serviceImpleClassName);
			String serviceImpleClassSimpleName = serviceImplClazz.getSimpleName();
			String pojoSimpleName = serviceImpleClassSimpleName.replaceAll("ServiceImpl", "");
			String pojoPackageName = serviceImplClazz.getPackage().getName().replaceAll(".service.impl", ".pojo");
			String pojoFullName = pojoPackageName +"."+ pojoSimpleName;
			clazz=Class.forName(pojoFullName);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}		
}
 


2.1 ����Ҫ��ȡ���ĸ���̳���BaseServiceImpl�������õ����������֪ʶ��ģ�ʵ�������࣬����Ĺ��췽��һ���ᱻ���� ��ôһ��֪ʶ�㣺
 
try{
			throw new Exception();	
		}
		catch(Exception e){
			StackTraceElement stes[]= e.getStackTrace();
		    String serviceImpleClassName=	stes[1].getClassName();
 

�����ڸ���BaseServiceImpl������׳�һ���쳣��Ȼ���ֶ���׽ס���������Ӧ��StackTrace��ĵڶ���(�±���1) ջ����Ԫ��StackTraceElement ������Ӧ���ࡣ �������Ǿ��õ����������� CategoryServiceImpl����ProductServiceImpl

2.2 �õ���CategoryServiceImpl����ProductServiceImpl��ͨ���ַ����滻��ƴ�Ӻͷ��䣬�͵õ��˶�Ӧ��ʵ����������Category.class����Product.class����
 
Class  serviceImplClazz= Class.forName(serviceImpleClassName);
String serviceImpleClassSimpleName = serviceImplClazz.getSimpleName();
String pojoSimpleName = serviceImpleClassSimpleName.replaceAll("ServiceImpl", "");
String pojoPackageName = serviceImplClazz.getPackage().getName().replaceAll(".service.impl", ".pojo");
String pojoFullName = pojoPackageName +"."+ pojoSimpleName;
clazz=Class.forName(pojoFullName);
 

������Ҫע����ǣ������������ǽ����ڷ���ʵ�����Ƿ���xxx.service.impl���µģ���ʵ�����Ƿ���xxx.pojo���µġ�

3. ͬʱ�ṩ��һ�����Է���������һ�£��������clazz�����Ƿ�ָ���������������
 
public static void main(String[] args) {
	new CategoryServiceImpl().showClass();
}
public void showClass(){
	System.out.println(clazz);
} */
  
public interface BaseService {
    public Integer save(Object object);
    public void update(Object object);
    public void delete(Object object);
    public Object get(Class clazz,int id);
    public Object get(int id);
     
    public List list();
    public List listByPage(Page page);
    public int total();
    
    public List listByParent(Object parent);
    public List list(Page page, Object parent);
    public int total(Object parentObject); 
    
    public List list(Object ...pairParms);
}
