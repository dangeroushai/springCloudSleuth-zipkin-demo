package com.demo.zipkin;

import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

	private static final Logger LOG = Logger.getLogger(ProviderApplication.class.getName());


	@RequestMapping("/foo/{consumer}")
	public String info(HttpServletRequest request, @PathVariable("consumer") String consumerName){
		LOG.info("Provider have been called");
		
		//输出请求头
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			System.out.println(headerName + ":" + headerValue);
		}
		
		String hiResult = consumerName + " call me";//restTemplate.getForObject("http://localhost:8988/info",String.class);
		
		System.err.println(hiResult);
		
		if(true){
//			throw new RuntimeException("sorry , it is a accident");
		}
		
		return "i see you " + consumerName;
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
