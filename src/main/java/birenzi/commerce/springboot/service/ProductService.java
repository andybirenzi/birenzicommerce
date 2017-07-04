package birenzi.commerce.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birenzi.commerce.springboot.pojo.Product;
import birenzi.commerce.springboot.repository.ProductRepository;

@Service("productService")
public class ProductService {
	@Autowired
	ProductRepository repo;

	public Product findProductById(int id) {

		return repo.findOne(id);
	}

	public Product findProductBySku(String sku) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findAllProduct() {

		return repo.findAll();
	}

	public boolean saveProduct(Product prod) {

		repo.save(prod);
		return true;
	}

	public boolean update(Product p) {
		repo.flush();
		return true;
	}

	public boolean deleteProduct(int id) {
		repo.delete(id);
		return true;
	}

}
