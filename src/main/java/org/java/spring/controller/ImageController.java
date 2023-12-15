package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Image;
import org.java.spring.db.serv.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/admin/images")
public class ImageController {

    @Autowired
    private ImageService imageService;
    
    
    
    @GetMapping
    public String index(Model model, @RequestParam(required = false) String q) {

    	
		List<Image> images = q == null ? imageService.findAll() : imageService.findByTitle(q);
		
		model.addAttribute("images", images);
		model.addAttribute("q", q == null ? "" : q);
    	
        return "images/image-index";
    }
    
    
    @GetMapping("/{id}")
    public String getImage(@PathVariable Long id, Model model) {

    	Image image = imageService.findById(id);
    	model.addAttribute("image", image);
    	
        return "images/image-detail";
    }
}
