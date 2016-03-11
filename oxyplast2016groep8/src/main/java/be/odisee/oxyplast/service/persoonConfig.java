package be.odisee.oxyplast.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class persoonConfig {
	
//	@Bean
//	public String constructorMessageString() {
//		return "Het leven is superconstructief";
//	}
	
	@Bean
	public String setNaam() {
		return "klant nummer 1";
	}
}
