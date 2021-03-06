package com.yfli.ssh.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yfli.ssh.pojo.Category;
import com.yfli.ssh.pojo.Product;
import com.yfli.ssh.service.OrderItemService;
import com.yfli.ssh.service.ProductImageService;
import com.yfli.ssh.service.ProductService;
import com.yfli.ssh.service.ReviewService;
 
@Service
public class ProductServiceImpl  extends BaseServiceImpl implements ProductService {
	@Autowired
    ProductImageService productImageService;
	
	@Autowired
    OrderItemService orderItemService;
	
	@Autowired
    ReviewService reviewService;
	
	@Override
    public List<Product> search(String keyword, int start, int count) {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.add(Restrictions.like("name", "%"+keyword+"%"));
        return findByCriteria(dc,start,count);
    }
     
    @Override
    public void setSaleAndReviewNumber(Product product) {
        int saleCount = orderItemService.total(product);
        product.setSaleCount(saleCount);
        int reviewCount = reviewService.total(product);
        product.setReviewCount(reviewCount);
    }
     
    @Override
    public void setSaleAndReviewNumber(List<Product> products) {
        for (Product product : products) {
            setSaleAndReviewNumber(product);
        }
    }
     
    public void fill(List<Category> categorys) {
        for (Category category : categorys) {
            fill(category);
        }
    }
 
    @Override
    public void fillByRow(List<Category> categorys) {
        int productNumberEachRow = 8;
        for (Category category : categorys) {
            List<Product> products =  category.getProducts();
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
             
            category.setProductsByRow(productsByRow);
        }
    }
     
    @Override
    public void fill(Category category) {
        List<Product> products= listByParent(category);
         
        for (Product product : products)
            productImageService.setFirstProdutImage(product);
         
        category.setProducts(products);
         
    }
}