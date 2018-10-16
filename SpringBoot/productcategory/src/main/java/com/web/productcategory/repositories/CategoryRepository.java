package com.web.productcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.productcategory.models.Category;
import com.web.productcategory.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
//	//add additional product
//	Category addProduct(Product product);
}
