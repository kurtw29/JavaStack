package com.web.productcategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.productcategory.models.Category;
import com.web.productcategory.models.Product;
import com.web.productcategory.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepo;
	
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	//Add a product
	public Product createProduct(Product product) {
		System.out.println("*** CAME TO ProductService createProduct(product)*****");
		return productRepo.save(product);
	}
	
	//Retrieve a product by given id
	public Product findProductById(Long id) {
		Optional<Product> optionalProd = productRepo.findById(id);
		if(optionalProd.isPresent()) {
			System.out.println("*** CAME TO ProductService findProductById(Long id) IS PRESENT*****");
			return optionalProd.get();
		}else
			System.out.println("*** CAME TO ProductService findProductById(Long id) NOT PRESENT*****");
			return null;
	}
	
	//Retrieve all products
	public Iterable<Product> findAllProducts(){
		return productRepo.findAll();
	}
	
	//add additional category of a product
	public Product addCategory(Category category, Long id) {
		//find the product of PathVariable, add "category" object"
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			//add model "category" onto the category List & save product
			List<Category> currentCategories = optionalProduct.get().getCategories();
			currentCategories.add(category);
			return productRepo.save(optionalProduct.get());
		}else {
			System.out.println("in ProductService // addCategory() \n***Unable to find product by ID");
			return null;
		}
	}
}
