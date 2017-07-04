package birenzi.commerce.springboot.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birenzi.commerce.springboot.pojo.Category;
import birenzi.commerce.springboot.repository.CategoryRepository;

@Service("categoryService")
public class CategoryService {
	
	@Autowired
	CategoryRepository repo;
	@PersistenceContext
	private EntityManager em;
    public void saveCategory(Category cat){
    	if(cat.getId()<=0)
    	repo.save(cat);
    	
    	
    	
    }
    public void updateCategory(Category cat){
    	repo.flush();
    }
    public List<Category> findAllCategories(){
    	List<Category> categories = new ArrayList<Category>();
    	for(Category cat:repo.findAll()){
    		if(cat.getParent()==null){
    			cat.setParent(new Category());
    			cat.getParent().setId(0);
    			cat.getParent().setLabel("-");
    		}
    		categories.add(cat);
    	}
    	return categories;
    }
    public void delete(int id){
    	repo.delete(id);
    }
    public Category findOne(int id){
    	
    	return repo.findOne(id);
    }
	
}
