package org.java.spring.restcontroller;

import java.util.List;

import org.java.spring.db.pojo.Image;
import org.java.spring.db.serv.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/api/admin/images")
public class ImageRestcontroller {

	
	@Autowired
	ImageService imageService;
	
	
	
	@GetMapping
	public ResponseEntity<List<Image>> getImages() {
		
		List<Image> images = imageService.findAll();
		
		System.out.println("ok");
		
		return new ResponseEntity<>(images, HttpStatus.OK);
	}
}
