package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloWorldController {
	
	@Autowired
	private HelloWorldAppService helloWorldAppService;
	
	@GetMapping("/hello")
	public String hello() {
		log.debug("Debugging log");
		log.info("Info log");
		log.warn("Hey, This is a warning!");
		log.error("Oops! We have an Error. OK");
		String val=helloWorldAppService.getHelloWorld();
		return val;
	}

}
