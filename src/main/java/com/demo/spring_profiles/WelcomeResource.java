package com.demo.spring_profiles;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeResource {
	
	@Autowired
	private BasicConfiguration configuration;
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@GetMapping("/welcome")
	public String retrieveWelcomeMessage() {
		return welcomeMessage;
	}
	
	@RequestMapping("/dynamic-configuration")
	public Map<String, Object> dynamicConfiguration() {
		Map map = new HashMap();
		map.put("message", configuration.getMessage());
		map.put("number", configuration.getNumber());
		map.put("key", configuration.isValue());
		return map;
	}
}
