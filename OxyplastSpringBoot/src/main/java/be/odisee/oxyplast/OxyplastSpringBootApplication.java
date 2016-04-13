package be.odisee.oxyplast;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
@ComponentScan("be.odisee.oxyplast")
@EntityScan("be.odisee.oxyplast.domain")
public class OxyplastSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxyplastSpringBootApplication.class, args);
	}
    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
        return hemf.getSessionFactory();
    }
    
	public void addViewControllers(ViewControllerRegistry registry) {
	  registry.addViewController("/login").setViewName("login");                 
	}  
}
