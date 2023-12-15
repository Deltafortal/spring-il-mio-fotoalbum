package org.java.spring.auth.db.pojo;

import java.util.Collection;
import java.util.List;

import org.java.spring.db.pojo.Image;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
    private String username;
    private String password;
    
    
    @OneToMany(mappedBy = "user")
    private List<Image> image;
    
    
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;
    
    
    
    //Constructor
    public User() {}
    public User(String username, String password, Role... roles) {
    	
    	setUsername(username);
    	setPassword(password);
    	setRoles(roles);
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
	
	
	//Role functions
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public void setRoles(Role... roles) {
		
		setRoles(List.of(roles));
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getName())).toList();
	}
	
	@Override public boolean isAccountNonExpired() { return true; }
	@Override public boolean isAccountNonLocked() { return true; }
	@Override public boolean isCredentialsNonExpired() { return true; }
	@Override public boolean isEnabled() { return true; }
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getUsername();
	}

}
