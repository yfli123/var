package com.yfli.ssh.dao;

import java.util.List;

import com.yfli.ssh.pojo.Product;
public interface ProductDAO {
    public List<Product> list();
    public void add(Product p);
	public Product get(int id);
	public void update(Product p);
	public void delete(Product p);	
}