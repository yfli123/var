package com.yfli.ssh.service;
import java.util.List;

import com.yfli.ssh.pojo.Product;
import com.yfli.ssh.pojo.ProductImage;
 
 
public interface ProductImageService extends BaseService {
     
    public static final String type_single = "type_single";
    public static final String type_detail = "type_detail";
     
    public void setFirstProdutImage(Product product);
     
}