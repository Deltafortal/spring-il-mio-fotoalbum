package org.java.spring.db.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Message {

	//Declaring variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
		
	private String email;
	private String message;
		
		
		
		//Constructor
		public Message() { }
		public Message(String email, String message) {
			
			setEmail(email);
			setMessage(message);
		}

		
		
		//Id fucntions
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

		
		
		//Email functions
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		
		
		
		//Message Functions
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
}
