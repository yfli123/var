package com.yfli.ssh.comparator;

import java.util.Comparator;

import com.yfli.ssh.pojo.Product;

public class ProductSaleCountComparator implements Comparator<Product>{
 
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getSaleCount()-p1.getSaleCount();
    }
 
}