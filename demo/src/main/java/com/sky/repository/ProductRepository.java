package com.sky.repository;

import java.util.List;

import com.sky.domain.Product;

public interface ProductRepository {

	public void addProduct(Product product);

	public List<Product> getProducts();

	public Product getProductByid(String id);

	public void deleteByID(String id);

	public void updateById(Product product);
}
