package com.learn.spring.aop;

import com.learn.spring.aop.business.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private BusinessService businessService;

	public AopApplication(BusinessService businessService) {
		this.businessService = businessService;
	}
	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Value returned is {}", businessService.calculateMax());
	}
}
