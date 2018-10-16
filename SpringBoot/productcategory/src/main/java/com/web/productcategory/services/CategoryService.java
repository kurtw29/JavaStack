package com.web.productcategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.productcategory.models.Category;
import com.web.productcategory.models.Product;
import com.web.productcategory.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepo;
	
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	//Create a category
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	//Retriave a category by id
	public Category findCategoryById(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			System.out.println("CAME TO CategoryService -> findCategoryById -> optionalCategory IS PRESENT");
			return optionalCategory.get();
		}else {
			System.out.println("CAME TO CategoryService -> findCategoryById -> optionalCategory NOT PRESENT - RETURNING NULL");
			return null;
		}
	}

	//Retrieve all categories
	public Iterable<Category> findAllCategories(){
		return categoryRepo.findAll();
	}
	
	
	//add additional product of a category
	public Category addProduct(Product product, Long id) {
		//find the category of PathVariable, add "product" object"
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			//add model "product" onto the product List & save category
			List<Product> currentProducts = optionalCategory.get().getProducts();
			currentProducts.add(product);
			return categoryRepo.save(optionalCategory.get());
		}else {
			System.out.println("in CategoryService // addProduct() \n***Unable to find category by ID");
			return null;
		}
	}
}
