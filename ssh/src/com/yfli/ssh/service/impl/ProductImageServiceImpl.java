package com.yfli.ssh.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
 
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.yfli.ssh.pojo.Product;
import com.yfli.ssh.pojo.ProductImage;
import com.yfli.ssh.service.ProductImageService;
 
 
@Service
public class ProductImageServiceImpl  extends BaseServiceImpl implements ProductImageService {
 
    @Override
    public void setFirstProdutImage(Product product) {
        if(null!=product.getFirstProductImage())
            return;
        List<ProductImage> pis= list("product", product, "type", ProductImageService.type_single);
        if(!pis.isEmpty())
            product.setFirstProductImage(pis.get(0));
    }
 
}