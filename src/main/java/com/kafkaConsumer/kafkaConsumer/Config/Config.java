package com.kafkaConsumer.kafkaConsumer.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.kafkaConsumer.kafkaConsumer.Model.User;

import org.apache.kafka.common.serialization.StringDeserializer;

/**
 * class Config
 * 
 * @author dines
 * @created Date 23/12
 * @desription used to create the singleton bean for consumer application
 *
 */
@Configuration
@EnableKafka
public class Config {
	
	/**
	 * message group variable
	 */
	@Value("${kafka.groupid.groupId1}")
	private String messagesGroup;
	
	/**
	 * function consumerFactory
	 * 
	 * @return ConsumerFactory<String, String> Bean
	 * @description singleton bean created for consumer factory
	 */
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String,Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, messagesGroup);
		return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),new StringDeserializer());
	}
	
	/**
	 * function concurrentKafkaListenerContainerFactory
	 * 
	 * @return ConcurrentKafkaListenerContainerFactory bean
	 * @description singleton bean created for ConcurrentKafkaListenerContainerFactory
	 */
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	/**
	 * function consumerUserFactory
	 * 
	 * @return ConsumerFactory<String, User> Bean
	 * @description singleton bean created for consumer factory
	 */
	@Bean
	public ConsumerFactory<String, User> consumerUserFactory() {
		Map<String,Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, messagesGroup);
		return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),new JsonDeserializer<>(User.class,false));
	}
	
	/**
	 * function concurrentKafkaListenerUserContainerFactory
	 * 
	 * @return ConcurrentKafkaListenerContainerFactory<String, User> bean
	 * @description singleton bean created for ConcurrentKafkaListenerContainerFactory
	 */
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, User> concurrentKafkaListenerUserContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<String, User>();
		factory.setConsumerFactory(consumerUserFactory());
		return factory;
	}
	

}
