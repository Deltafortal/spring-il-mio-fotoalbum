package org.java.spring;

import org.java.spring.auth.db.pojo.Role;
import org.java.spring.auth.db.pojo.User;
import org.java.spring.auth.db.service.RoleService;
import org.java.spring.auth.db.service.UserService;
import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Image;
import org.java.spring.db.serv.CategoryService;
import org.java.spring.db.serv.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{

	
	@Autowired
	private ImageService imageServ;
	
	
	@Autowired
	private CategoryService categoryService;
	
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {
	
		
		
		//Category
		Category macro = new Category("macro");
		Category chill = new Category("chill");
		Category bug = new Category("bug");
		Category buff = new Category("buff");
		
		
		categoryService.save(macro);
		categoryService.save(chill);
		categoryService.save(bug);
		categoryService.save(buff);

		
		
		//Role
		Role roleUser = new Role("USER");
		Role roleAdmin = new Role("ADMIN");
		Role roleSuperAdmin = new Role("SUPER_ADMIN");
		
		
		roleService.save(roleUser);
		roleService.save(roleAdmin);
		roleService.save(roleSuperAdmin);
		
		
		//Password
		String pws = passwordEncoder.encode("pws");
		
		
		//User
		User user = new User("user", pws, roleUser);
		User admin = new User("admin", pws, roleAdmin);
		User adminSuper = new User("adminSuper", pws, roleSuperAdmin);
		
		userService.save(user);
		userService.save(admin);
		userService.save(adminSuper);
		
		
		//Images
		Image img = new Image("Drake", "Descrizione del drago", "blabla", true, user, macro);
		imageServ.save(img);
		
		imageServ.save(new Image("Super Buff", "Descrizione del buff", "blablaurl", true, user, buff));
		
	}
}
