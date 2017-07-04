package birenzi.commerce.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import birenzi.commerce.springboot.pojo.Brand;

public interface BrandRepository  extends JpaRepository<Brand, Integer>{
     
}
