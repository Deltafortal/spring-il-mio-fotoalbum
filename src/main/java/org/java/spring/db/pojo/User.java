package org.java.spring.db.pojo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
    private String username;
    private String password;
    
    
    @OneToMany(mappedBy = "user")
    private List<Image> image;
    
    
    
    
    
    //Constructor
    public User() {}
    public User(String username, String password) {
    	
    	setUsername(username);
    	setPassword(password);
    }
    
    
    
    
 
	//Id Functions
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	//Username functions
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	//Password functions
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
	
	//Image functions
    public List<Image> getImage() {
		return image;
	}
	public void setImage(List<Image> image) {
		this.image = image;
	}

}
