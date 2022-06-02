package com.sky.service;

import java.util.List;

import com.sky.domain.Product;
public interface ProductService {
	
	
	
    public void addProduct(Product product);
    public List<Product> getProducts();
    public  Product getProductByid(String id);
    public  void deleteByID( String id);
    public void updateById(Product product);
}
