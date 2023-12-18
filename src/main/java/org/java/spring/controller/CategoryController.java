package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.serv.CategoryService;
import org.java.spring.db.serv.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

	
	//Declaring variables
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	
	//Index
	@GetMapping
	public String getCategories(Model model) {
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
	
		return "categories/category-index";
	}
	
	
	
	//Create
	@GetMapping("/create")
	public String createCategory(Model model) {
		
		List<Category> categories = categoryService.findAll();
		
		model.addAttribute("categories", categories);
		
		return "categories/category-form";
	}
	
	
	//Store
	@PostMapping("/create")
	public String storeCategory(Model model, @Valid @ModelAttribute Category category, BindingResult bindingResult) {
		
		categoryService.save(category);
		
		return "redirect:/admin/categories";
	}
	
	
}
