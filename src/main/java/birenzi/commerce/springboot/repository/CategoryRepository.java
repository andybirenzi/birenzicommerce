package birenzi.commerce.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import birenzi.commerce.springboot.pojo.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
