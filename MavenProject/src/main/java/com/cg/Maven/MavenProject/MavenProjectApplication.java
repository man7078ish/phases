package com.cg.Maven.MavenProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
@EntityScan("com.cg.beans")
public class MavenProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenProjectApplication.class, args);
	}
	
	
	

}
