package org.java.spring.db.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ImageDto {
	
	
	//Declaring variables
    @NotBlank(message = "Il titolo non può essere vuoto")
    private String title;

    @NotBlank(message = "La descrizione non può essere vuota")
    private String description;

    @NotBlank(message = "L'URL non può essere vuoto")
    private String url;

	@NotNull(message = "La visibilità non può essere nulla")
    private Boolean visible;
    
    
    
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

	
	//Visibility functions
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

}
