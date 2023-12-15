package org.java.spring.db.serv;

import java.util.List;

import org.hibernate.Hibernate;
import org.java.spring.db.pojo.Image;
import org.java.spring.db.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ImageService {

	
	@Autowired
	private ImageRepo imageRepo;
	
	
	
	@Transactional
	public List<Image> findAll() {
		
		List<Image> images = imageRepo.findAll();
		
		images.forEach(i -> Hibernate.initialize(i.getCategories()));		
		return images;
	}
	
	
	
	public Image findById(Long id) {
		
		return imageRepo.findById(id).get();
	}
	
	
	
	public List<Image> findByTitle(String title) {
		
		return imageRepo.findByTitleContainingIgnoreCase(title);
	}
	
	
	
	public void save(Image image) {
		
		imageRepo.save(image);
	}
	
	
	
	public void delete(Image image) {
		
		imageRepo.delete(image);
	}
	
}
