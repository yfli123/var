package com.yfli.struts.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yfli.struts.bean.Category;
import com.yfli.struts.bean.Product;

public class ProductAction/* extends ActionSupport*/{
    private Product product;
    
    private List<Product> products;
    
    private List<Integer> selectedProducts;
    
    private List<Category> categories =new ArrayList();
    
    private Date date;
    
    private String name;
    
    public ProductAction(){
        System.out.println("product action instance: " + this);
    }
    
    
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getDate() {
        return date;
    }
 
    public void setDate(Date date) {
        this.date = date;
    }
    
    
    public List<Category> getCategories() {
        return categories;
    }
 
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    public List<Integer> getSelectedProducts() {
        return selectedProducts;
    }
 
    public void setSelectedProducts(List<Integer> selectedProducts) {
        this.selectedProducts = selectedProducts;
    } 
 
    public String show() {
    	HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
 
        System.out.println("request:\t" + request);
        System.out.println("response:\t" + response);
    	
        product = new Product();
        product.setName("iphone7");
        return "show";
    }
    /*
     * 在add方法中获取Struts定义的Session
		Map m = ActionContext.getContext().getSession();
		然后把 name放进去 */
    public String add(){
    	Map m = ActionContext.getContext().getSession();
        m.put("name", product.getName());
        System.out.println("product.name:"+product.getName());
        return "show";
    }
    
    public String addPage(){
    	name = "default name";
        return "addPage";
    }
    
   /* public void validate(){
        if ( product.getName().length() == 0 ){
        	// 需要继承 ActionSupport 
            addFieldError( "product.name", "name can't be empty" );
        }
    }  */ 
    
    public String list() {
    	  
        products=new ArrayList<Product>();
        selectedProducts = new ArrayList<Integer>();
  
        Category category1 =new Category();
        category1.setId(1);
        category1.setName("category1");
         
        Category category2 =new Category();
        category2.setId(2);
        category2.setName("category2");
         
        categories.add(category1);
        categories.add(category2);
        
        List<Product> products1=new ArrayList();
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("product1");
        Product p2 = new Product();
        p2.setId(2);
        p2.setName("product2");
        Product p3 = new Product();
        p3.setId(3);
        p3.setName("product3");
  
        products1.add(p1);
        products1.add(p2);
        products1.add(p3);
         
        List<Product> products2=new ArrayList();
        Product p4 = new Product();
        p4.setId(4);
        p4.setName("product4");
        Product p5 = new Product();
        p5.setId(5);
        p5.setName("product5");
        Product p6 = new Product();
        p6.setId(6);
        p6.setName("product6");
         
        products2.add(p4);
        products2.add(p5);
        products2.add(p6);
         
        category1.setProducts(products1);
        category2.setProducts(products2);
        selectedProducts.add(2);
        selectedProducts.add(3);
  
        return "list";
  
    }
    
 
    public Product getProduct() {
        return product;
    }
 
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public List<Product> getProducts() {
        return products;
    }
  
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
