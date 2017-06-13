package birenzi.commerce.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import birenzi.commerce.springboot.pojo.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	Product findBySku(String sku);

}
