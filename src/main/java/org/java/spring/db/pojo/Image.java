package org.java.spring.db.pojo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.java.spring.auth.db.pojo.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Length(min = 2, max = 60, message = "Il titolo deve essere compreso tra 1 e 60 caratteri")
    private String title;
	
    private String description;
    
    private String url;
    
    @NotNull(message = "La visibilità non può essere nulla")
    private boolean isVisible;

    
    
    //Constructor
    public Image() {}
    public Image(String title, String description, String url, boolean isVisible, User user, Category...categories) {
    	
    	setTitle(title);
    	setDescription(description);
    	setUrl(url);
    	setVisible(isVisible);
    	setUser(user);
    	setCategories(categories);
    }
    
    
    
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    private List<Category> categories;
    
    
    
    //id functions
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	//Title functions
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	//Description functions
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	//Url functions
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
	//Visible functions
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	
	
	//User functions
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	//category functions
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public void setCategories(Category...categories) {	
		setCategories(Arrays.asList(categories));
	}
	public void clearCategories() {
		getCategories().clear();
	}
}
