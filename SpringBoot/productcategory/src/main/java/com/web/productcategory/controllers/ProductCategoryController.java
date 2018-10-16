package com.web.productcategory.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.productcategory.models.Category;
import com.web.productcategory.models.Product;
import com.web.productcategory.services.CategoryService;
import com.web.productcategory.services.ProductService;

@Controller
public class ProductCategoryController {
	ProductService productServ;
	CategoryService categoryServ;
	public ProductCategoryController(ProductService productServ, CategoryService categoryServ) {
		this.productServ = productServ;
		this.categoryServ = categoryServ;
	}
	//serving index jsp - Home page with 
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("products", productServ.findAllProducts());
		model.addAttribute("categories", categoryServ.findAllCategories());
		return "index.jsp";
	}
	
	//serving New-Product jsp - form to create
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	//process POST new-Product form
	@RequestMapping(value="/product/create", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}else {
			System.out.println("Came to POST /product/create productServ.createProduct product: "+product);
			Product newProduct = productServ.createProduct(product);
			return "redirect:/products/"+newProduct.getId(); //redirect to show-product & pass ${product.id} in url
		}
	}
	
	//serving New-Category jsp - form to create
	@RequestMapping("/categories/new")
	public String newCategories(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	//process POST new-Category form
	@RequestMapping(value="/category/create", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}else {
			Category newCategory = categoryServ.createCategory(category);
			return "redirect:/categories/"+newCategory.getId(); //redirect to show-category & pass ${category.id} in url
		}
	}
	
	//process show-Products
	@RequestMapping(value="/products/show", method=RequestMethod.POST)
	public String toShowProduct(@RequestParam(value="productId") Long id) {
		return "redirect:/products/"+id;
	}
	
	//serving show-product jsp
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product selectedProduct = productServ.findProductById(id);
		model.addAttribute("product", selectedProduct);
		//list all categories of a selected product
		model.addAttribute("categories", selectedProduct.getCategories());
		//list all categories
		List<Category> categoriesExcluded = (List<Category>) categoryServ.findAllCategories();
		//if the category is not found in categoriesOfProduct -> remove the category
		if(selectedProduct.getCategories() != null) {
			categoriesExcluded.removeAll(selectedProduct.getCategories());
		}
		//return the category list -> list of all other categories not found in selectedProduct
		model.addAttribute("categoriesExcluded", categoriesExcluded);
		return "showProduct.jsp";
	}
	
	//process POST product_add-category form
	@RequestMapping(value="/product/{id}/addCategory", method=RequestMethod.POST)
	public String productAddCategory(@PathVariable("id") Long id, @RequestParam("categoryId") Long categoryId) {
		Category category = categoryServ.findCategoryById(categoryId);
		Product updatedProduct = productServ.addCategory(category, id);
		return "redirect:/products/"+updatedProduct.getId();
	}
	
	//process show-Categories
	@RequestMapping(value="/categories/show", method=RequestMethod.POST)
	public String toShowCategory(@RequestParam(value="categoryId") Long id) {
		return "redirect:/categories/"+id;
	}
	
	//serving show-Category jsp
	@RequestMapping("/categories/{id}") //change to {category's id}
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category selectedCategory = categoryServ.findCategoryById(id);
		model.addAttribute("category", selectedCategory);
		//list all products of a selected category
		List<Product> productsOfCategory = selectedCategory.getProducts();
		model.addAttribute("products", productsOfCategory);
		//create a list of all product
		List<Product> productsExcluded = (List<Product>) productServ.findAllProducts();
		//if the product is not found in productsOfCategory -> remove the product
		if(selectedCategory.getProducts() != null) {
			productsExcluded.removeAll(selectedCategory.getProducts());
		}
		//return the product list -> list of all other products not found in selectedCategory
		model.addAttribute("productsExcluded",  productsExcluded);
		return "showCategory.jsp";
	}
	
	//process POST category_add-product to form
		@RequestMapping(value="/category/{id}/addProduct", method=RequestMethod.POST)
		public String categoryAddProduct(@PathVariable("id") Long id, @RequestParam("productId") Long productId) {
			Product product = productServ.findProductById(productId);
			Category updatedCategory = categoryServ.addProduct(product, id);
			return "redirect:/categories/"+updatedCategory.getId();
		}
}
