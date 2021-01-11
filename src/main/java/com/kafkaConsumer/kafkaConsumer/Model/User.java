package com.kafkaConsumer.kafkaConsumer.Model;

import lombok.Data;

/**
 * class User
 * 
 * @author dines
 * @created date 22/12
 *
 */
@Data
public class User {

	/**
	 * id of the user
	 */
	private int id;
	
	/**
	 * name of the user
	 */
	private String name;
	
	/**
	 * email of the user
	 */
	private String email;
	
	/**
	 * mobile no of the user
	 */
	private String mobile;
	
}
