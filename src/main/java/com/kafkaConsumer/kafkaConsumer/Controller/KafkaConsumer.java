package com.kafkaConsumer.kafkaConsumer.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kafkaConsumer.kafkaConsumer.KafkaListener.KafkaListen;
import com.kafkaConsumer.kafkaConsumer.Model.User;




/**
 * class KafkaConsumer
 * 
 * 
 * @author dines
 * @Created Date 23/12
 * @description used to consume the message from kafka broker
 *
 */
@RestController
@RequestMapping("consume")
public class KafkaConsumer {
	
	private final KafkaListen kafkaListen;
	
	@Autowired
	KafkaConsumer(KafkaListen kafkaListen) {
		this.kafkaListen = kafkaListen;
	}
	/**
	 * function getMessages
	 * 
	 * @return List of messages
	 * @description consumer consumes the List of messages
	 */
	@GetMapping("/messages")
	public List<String> getMessages() {
		return kafkaListen.getMessages();
	}
	
	/**
	 * function listOutUsers
	 * 
	 * @return userDetails
	 * @description displays the user details
	 */
	@GetMapping("/user")
	public User listOutUsers() {
		return kafkaListen.myUser;
	}
	

	
	

	

}
