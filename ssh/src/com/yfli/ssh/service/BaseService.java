package com.yfli.ssh.service;

import java.util.List;

import com.yfli.ssh.util.Page;

/* 可是现在有一个问题，BaseServiceImpl类里面有一行
 
Class clazz =Category.class;
 

表示这个BaseServiceImpl是专门用于进行Category类的CURD的，如果是后续要做的产品功能对应的ProductService继承BaseServiceImpl 这个类，不就有问题了吗？

这个问题怎么解决呢？ 这个。。。这个。。。。处理起来比较复杂，分以下几个步骤进行
1. 声明clazz的时候，不再指向Category.class 对象
 
protected Class clazz;
 


2. 在构造方法中，借助异常处理和反射得到Category.class或者Product.class。 即要做到哪个类继承了BaseServiceImpl，clazz 就对应哪个类对象。
比如是 CategoryServiceImpl继承了BaseServiceImpl,那么这个clazz的值就是Category.class
比如是 ProductServiceImpl继承了BaseServiceImpl,那么这个clazz的值就是Product.class

 
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
 


2.1 首先要获取是哪个类继承了BaseServiceImpl，这里用到了面向对象知识里的：实例化子类，父类的构造方法一定会被调用 这么一个知识点：
 
try{
			throw new Exception();	
		}
		catch(Exception e){
			StackTraceElement stes[]= e.getStackTrace();
		    String serviceImpleClassName=	stes[1].getClassName();
 

所以在父类BaseServiceImpl里故意抛出一个异常，然后手动捕捉住它，在其对应的StackTrace里的第二个(下标是1) 栈跟踪元素StackTraceElement ，即对应子类。 这样我们就拿到了子类名称 CategoryServiceImpl或者ProductServiceImpl

2.2 拿到了CategoryServiceImpl或者ProductServiceImpl，通过字符串替换，拼接和反射，就得到了对应的实体类的类对象Category.class或者Product.class对象。
 
Class  serviceImplClazz= Class.forName(serviceImpleClassName);
String serviceImpleClassSimpleName = serviceImplClazz.getSimpleName();
String pojoSimpleName = serviceImpleClassSimpleName.replaceAll("ServiceImpl", "");
String pojoPackageName = serviceImplClazz.getPackage().getName().replaceAll(".service.impl", ".pojo");
String pojoFullName = pojoPackageName +"."+ pojoSimpleName;
clazz=Class.forName(pojoFullName);
 

这里需要注意的是，这样的做法是建立在服务实现类是放在xxx.service.impl包下的，而实体类是放在xxx.pojo包下的。

3. 同时提供了一个测试方法，运行一下，看看这个clazz引用是否指向了期望的类对象。
 
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
