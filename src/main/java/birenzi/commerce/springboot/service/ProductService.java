package birenzi.commerce.springboot.service;

import java.util.List;

import birenzi.commerce.springboot.pojo.Product;

public interface ProductService {
  public Product findProductById(int id);
  public Product findProductBySku(String sku);
  public List<Product> findAllProduct();
  public boolean saveProduct(Product prod);
}
