package oxyplast2016;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("be.odisee.oxyplast")
@EntityScan("be.odisee.oxyplast.domain.Project")
public class Oxyplast2016Wa {

	public static void main(String[] args) {
		SpringApplication.run(Oxyplast2016Wa.class, args);
	}
	
    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
        return hemf.getSessionFactory();
    }
	
}
