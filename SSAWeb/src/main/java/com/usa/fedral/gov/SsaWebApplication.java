package com.usa.fedral.gov;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SsaWebApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication  app = new SpringApplication(SsaWebApplication.class);
	    
		
		app.setBannerMode(Banner.Mode.OFF);
	    app.run(args);
	
	}

}
