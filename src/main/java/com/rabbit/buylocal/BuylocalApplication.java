package com.rabbit.buylocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rabbit.buylocal.dao.IDAOMarker;
import com.rabbit.buylocal.resource.IResourceMarker;
import com.rabbit.buylocal.service.IServiceMarker;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {IResourceMarker.class, IServiceMarker.class, IDAOMarker.class})
public class BuylocalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuylocalApplication.class, args);
	}

}
