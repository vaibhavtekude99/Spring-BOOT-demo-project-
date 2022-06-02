package com.sky.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.domain.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private static List<Product> products = new ArrayList<Product>();

	@Override
	public void addProduct(Product product) {
		System.out.println("in repository");
		products.add(product);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public Product getProductByid(String id) {

		Iterator<Product> itr = products.iterator();

		while (itr.hasNext()) {
			Product product1 = (Product) itr.next();

			if (product1.getProductId().equals(id))
				return product1;
		}

		return null;
	}

	@Override
	public void deleteByID(String id) {
		int i = 0;
		int index = 0;
		Product product2 = null;
		for (Product product : products) {
			if (product.getProductId().equals(id)) {
				index = i;
				product2 = product;
			}
			i++;

		}

		products.remove(index);

	}

	@Override
	public void updateById(Product newproduct) {

		String product_Id = newproduct.getProductId();

		int i = 0;

		for (Product product2 : products) {
			if (product2.getProductId().equals(product_Id)) {
				products.set(i, newproduct);
				

			}
			i++;
		}

		
	}

}
