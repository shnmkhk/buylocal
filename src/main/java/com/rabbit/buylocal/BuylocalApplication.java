package com.rabbit.buylocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rabbit.buylocal.resource.IResourceMarker;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {IResourceMarker.class})
public class BuylocalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuylocalApplication.class, args);
	}

}
