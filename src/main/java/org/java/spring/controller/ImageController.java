package org.java.spring.controller;

import java.util.List;

import org.java.spring.auth.db.pojo.User;
import org.java.spring.auth.db.service.UserService;
import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Image;
import org.java.spring.db.serv.CategoryService;
import org.java.spring.db.serv.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/{admin}/images")
public class ImageController {

    @Autowired
    private ImageService imageService;
    
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private UserService userService;
    
    
    
    //Index
    @GetMapping
    public String index(@PathVariable Long admin, Model model, @RequestParam(required = false) String q) {

    	
		List<Image> images = q == null ? imageService.findByUserId(admin) : imageService.findByTitle(q);
		Long user = admin;
		
		model.addAttribute("images", images);
		model.addAttribute("user", user);
		model.addAttribute("q", q == null ? "" : q);
    	
        return "images/image-index";
    }
    
    
    
    
    //Show
    @GetMapping("/{id}")
    public String getImage(@PathVariable Long admin, @PathVariable Long id, Model model) {

    	Image image = imageService.findByUserIdAndId(admin, id);
    	model.addAttribute("image", image);
    	
        return "images/image-detail";
    }
    
    
    
    //Create
    @GetMapping("/create")
    public String createImage(@PathVariable Long admin, Model model) {
    	
    	
    	Image image = new Image();
    	User user = userService.findById(admin);
    	image.setUser(user);
    	
    	List<Category> categories = categoryService.findAll();
    	
    	System.out.println("User = " + user);
    	
    	model.addAttribute("image", image);
    	model.addAttribute("categories", categories);
    	model.addAttribute("user", user);
    	
    	return "images/image-form";
    }
    
    
    //Store
    @PostMapping("/create")
    public String storeImage(Model model, @Valid @ModelAttribute Image image, BindingResult bindingResult) {
    	
    	return saveImage(model, image, bindingResult);
    }
    
    
    
    //Edit
    @GetMapping("/edit/{id}")
    public String editImage(Model model, @PathVariable Long id) {
    	
    	Image image = imageService.findById(id);
    	List<Category> categories = categoryService.findAll();
    	
    	model.addAttribute("image", image);
    	model.addAttribute("categories", categories);
    	
    	
    	return "images/image-form";
    }
    
    
    
    //Update
    @PostMapping("/edit/{id}")
    public String updateImage(Model model, @Valid @ModelAttribute Image image, BindingResult bindingResult) {
    	
    	return saveImage(model, image, bindingResult);
    }
    
    
    
    
    //Delete
    @PostMapping("/delete/{id}")
    public String deleteImage(@PathVariable Long id) {
    	
    	
    	Image image = imageService.findById(id);
    	
    	image.clearCategories();
    	imageService.save(image);
    	
    	imageService.delete(image);
    	
    	return "redirect:/admin/images";
    }
    
    
    
    
    //Other Functions
    public String saveImage(Model model, @Valid @ModelAttribute Image image, BindingResult bindingResult) {
    	
    	
    	if (bindingResult.hasErrors()) {
    		
			model.addAttribute("image", image);
			return "images/image-form";
			
		} 
    	
    	try {
    		
			imageService.save(image);
			
		} catch(Exception e) {
			
			model.addAttribute("image", image);
			return "images/image-form";
		}
    	
		return "redirect:/admin/images";
    }
}
