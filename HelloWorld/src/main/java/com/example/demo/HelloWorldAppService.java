package com.example.demo;

import java.util.Date;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HelloWorldAppService {
	
	public String getHelloWorld() {
		log.info("inside service ");
		Date date =new Date();
		return "hello-world" +date.toString();
		
	}

}
