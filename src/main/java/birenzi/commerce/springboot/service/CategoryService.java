package birenzi.commerce.springboot.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birenzi.commerce.springboot.pojo.Category;
import birenzi.commerce.springboot.repository.CategoryRepository;

@Service("categoryService")
public class CategoryService {
	@Autowired
	CategoryRepository repo;
	
    public void saveCategory(Category cat){
    	repo.save(cat);
    }
    public List<Category> findAllCategories(){
    	return repo.findAll();
    }
	
}
