package com.sky.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sky.domain.Product;

@Repository("ProductRepositoryDBImpl")
public class ProductRepositoryDBImpl implements ProductRepository {

	private static String INSERT_PRODUCT_SQL = "insert into PRODUCT(PRODUCT_ID,PRODUCT_NAME,PRODUCT_PRICE) VALUES (?,?,?)";
	private static String ALL_PRODUCT_SQL = "SELECT * FROM PRODUCT";
	private static String GET_PRODUCT_BY_ID = "SELECT * FROM PRODUCT WHERE PRODUCT_ID=?";
	private static String DELETE_PRODUCT_BY_ID = "DELETE FROM PRODUCT WHERE PRODUCT_ID=?";
	private static String UPDATE_PRODUCT_BY_ID="UPDATE PRODUCT SET PRODUCT_NAME=?, PRODUCT_PRICE=? WHERE  PRODUCT_ID=? ";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addProduct(Product product) {
		jdbcTemplate.update(INSERT_PRODUCT_SQL, product.getProductId(), product.getProductName(), product.getPrice());
	}

	@Override
	public List<Product> getProducts() {
		return this.jdbcTemplate.query(ALL_PRODUCT_SQL, new ProductRowMapper());
	}

	@Override
	public Product getProductByid(String id) {

		return this.jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID, new Object[] { id }, new ProductRowMapper());

	}

	@Override
	public void deleteByID(String id) {
		this.jdbcTemplate.update(DELETE_PRODUCT_BY_ID, id);
	}

	@Override
	public void updateById(Product product) {
		
		jdbcTemplate.update(UPDATE_PRODUCT_BY_ID,new Object[] {product.getProductName(),product.getPrice(),product.getProductId() });
		
	}

	private static final class ProductRowMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getString("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			return product;
		}

	}

}
