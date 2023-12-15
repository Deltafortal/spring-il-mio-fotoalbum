package org.java.spring.db.pojo;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Category {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
    private String name;
    
    
    @ManyToMany(mappedBy = "categories")
    private List<Image> images;
    


	//Constructor
    public Category() { }
    public Category(String name) {
    	
    	setName(name);
    }
    
    
    
    //Id Functions
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	//Name Functions
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	//Image Functions
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
} 
