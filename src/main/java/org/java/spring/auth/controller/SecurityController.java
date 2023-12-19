package org.java.spring.auth.controller;

import org.java.spring.auth.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class SecurityController {

	@Autowired
	private UserService userService;
	
	
	
	
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
    
    
    @GetMapping("/")
    public String welcome(Model model) {
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
    	
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();

    	model.addAttribute("user", userDetails);
    	model.addAttribute("roles", userDetails.getAuthorities());
            

        
        return "landing-page";
    }
}
