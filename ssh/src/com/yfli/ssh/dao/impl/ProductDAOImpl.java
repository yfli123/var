package com.yfli.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yfli.ssh.dao.ProductDAO;
import com.yfli.ssh.pojo.Product;
 
/* 
	1. 使用Repository 为ProductDAOImpl 添加注解
	2. 重写setSessionFactory方法，并使用@Resource(name="sf")对其注解，以接受sessionFactory注入( 在 applicationContext.xml中sessionFactory所取得id是sf)
	为什么要重写？
	虽然ProductDAOImpl 继承了HibernateTemplate ，有setSessionFactory方法，但是HibernateTemplate 中的setSessionFactory方法，并没有被注解，所以就不会被注入sf, 因此需要在这里重写这个方法 
*/
@Repository("productDAO")
public class ProductDAOImpl extends HibernateTemplate implements ProductDAO{
    
	@Resource(name="sf")
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    };
	
    public List<Product> list() {
        return find("from Product");
    }
 
    @Override
    public void add(Product p) {
        save(p);
    }
    
    @Override
	public Product get(int id) {
		return (Product)get(Product.class,id);
	}

	@Override
	public void update(Product p) {
		super.update(p);
		
	}

	@Override
	public void delete(Product p) {
		super.delete(p);
	}
     
}
