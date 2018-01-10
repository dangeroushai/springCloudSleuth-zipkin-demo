package com.demo.zipkin;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	private static final Logger LOG = Logger.getLogger(ConsumerApplication.class.getName());


	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/")
	public String callHome(){
		LOG.info("Consumer recevied a request");
		
		String miyaResult = restTemplate.getForObject("http://localhost:8989/foo/TestConsumer", String.class);
		
		System.err.println(miyaResult);
		
		return miyaResult;
	}
}
