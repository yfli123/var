package com.yfli.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(EurekaApp.class, args);
		//SpringApplication.run(EurekaApp.class, args);
	}

}
