package birenzi.commerce.springboot.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;

import birenzi.commerce.springboot.pojo.Product;
import birenzi.commerce.springboot.repository.ProductRepository;
@Service("productService")
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository repo;

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductBySku(String sku) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllProduct() {
		
		return  repo.findAll();
	}

	@Override
	public boolean saveProduct(Product prod) {
		repo.save(prod);
		return true;
	}

}
