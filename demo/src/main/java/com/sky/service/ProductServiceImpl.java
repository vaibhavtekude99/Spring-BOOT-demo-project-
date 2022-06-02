package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sky.domain.Product;
import com.sky.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	@Qualifier("ProductRepositoryDBImpl")
     private ProductRepository productRepository;
	@Override
	public void addProduct(Product product) {

		System.out.println("in service");
		if(product.getPrice()>20)
			productRepository.addProduct(product);
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}

	@Override
	public Product getProductByid(String id) {
		// TODO Auto-generated method stub
		return productRepository.getProductByid(id);
	}

	@Override
	public void deleteByID(String id) {
		// TODO Auto-generated method stub
		 productRepository.deleteByID(id);
	}

	@Override
	public void updateById(Product product) {
		// TODO Auto-generated method stub
		 productRepository.updateById(product);
	}

}
