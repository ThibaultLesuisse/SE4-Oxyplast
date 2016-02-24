package BE.Odisee.Oxyplast.Service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"BE.Odisee.Oxyplast.Domain", "BE.Odisee.Oxyplast.Service"})
public class persoonConfig {
	
	@Bean
	public String setNieuweLeverancierNaam() {
		return "Naam van de leverancier";
	}
	
	@Bean
	public String setNieuweNaam() {
		return "Naam van de klant";
	}
}
