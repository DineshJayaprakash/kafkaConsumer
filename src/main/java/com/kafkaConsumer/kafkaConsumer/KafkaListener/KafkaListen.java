package com.kafkaConsumer.kafkaConsumer.KafkaListener;

import java.util.ArrayList;
import java.util.List;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafkaConsumer.kafkaConsumer.Model.User;

@Component
public class KafkaListen {

	/**
	 * List of myMessages
	 */
	private List<String> myMessages = new ArrayList<String>();
	
	/**
	 * myUser object
	 */
	public User myUser = null;
	
	/**
	 * function getMessages
	 * 
	 * @return List of messages
	 * @description consumer consumes the List of messages
	 */
	public List<String> getMessages() {
		return myMessages;
	}
	
	/**
	 * function listOutUsers
	 * 
	 * @return userDetails
	 * @description displays the user details
	 */
	public User listOutUsers() {
		return myUser;
	}
	
	/**
	 * function getMsgFromTopic
	 * 
	 * @param data
	 * @return List of Messages gets consumed from producer
	 */
	@KafkaListener(groupId="${kafka.groupid.groupId1}",topics="${kafka.topic1}",containerFactory ="concurrentKafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data) {
		myMessages.add(data);
		return myMessages;
	}
	
	/**
	 * function getUserFromTopic
	 * 
	 * @param data
	 * @return UserDetails
	 * @description userDetails gets displayed from producer
	 */
	@KafkaListener(groupId="${kafka.groupid.groupId2}",topics="${kafka.topic2}",containerFactory ="concurrentKafkaListenerUserContainerFactory")
	public User getUserFromTopic(User data) {
		myUser = data;
		return myUser;
	}
	
}
