package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.serv.CategoryService;
import org.java.spring.db.serv.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



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
	
	
}
