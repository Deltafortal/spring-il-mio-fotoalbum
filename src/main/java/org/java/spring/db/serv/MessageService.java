package org.java.spring.db.serv;

import java.util.List;

import org.java.spring.db.pojo.Message;
import org.java.spring.db.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class MessageService {

	@Autowired
	MessageRepo messageRepo;
	
	
	@Transactional
	public List<Message> findAll() {
		
		List<Message> messages = messageRepo.findAll();
		
		return messages;
	}
	
	
	
	public Message findById(Long id) {
		
		return messageRepo.findById(id).get();
	}
	
	
	
	public void save(Message message) {
		
		messageRepo.save(message);
	}
}
