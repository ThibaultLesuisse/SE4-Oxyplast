package BE.Odisee.Oxyplast.Service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"BE.Odisee.Oxyplast.Domain"})
public class persoonConfig {
	
	@Bean
	public String setNieuweLeverancierNaam() {
		return "Het leven is superconstructief";
	}
	
	@Bean
	public String setNieuweNaam() {
		return "klant nummer 1";
	}
}
