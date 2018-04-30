package com.yfli.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yfli.ssh.dao.ProductDAO;
import com.yfli.ssh.pojo.Product;
 
/* 
	1. ʹ��Repository ΪProductDAOImpl ���ע��
	2. ��дsetSessionFactory��������ʹ��@Resource(name="sf")����ע�⣬�Խ���sessionFactoryע��( �� applicationContext.xml��sessionFactory��ȡ��id��sf)
	ΪʲôҪ��д��
	��ȻProductDAOImpl �̳���HibernateTemplate ����setSessionFactory����������HibernateTemplate �е�setSessionFactory��������û�б�ע�⣬���ԾͲ��ᱻע��sf, �����Ҫ��������д������� 
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
