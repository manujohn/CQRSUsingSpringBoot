package com.example.event;

import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.event.exception.EventException;

@SpringBootApplication
public class EventDrivenApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventDrivenApplication.class, args);
	}

	@Autowired
	public void configure(EventProcessingConfigurer config) {
		config.registerListenerInvocationErrorHandler("product", cofiguration -> new EventException());
	}
}
