package BE.Odisee.Oxyplast.Service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import BE.Odisee.Oxyplast.Domain.*;


@Component
public class DependencyInjectionMain {
	
	public static IPersoon persoon1, persoon2;
	
	@SuppressWarnings("unused")
	private static ApplicationContext applicationContext;
	
	@Autowired
    public DependencyInjectionMain(IPersoon persoon1, IPersoon persoon2){
    	
		DependencyInjectionMain.persoon1 = persoon1;
		DependencyInjectionMain.persoon2 = persoon2;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Spring context aan het initialiseren.");

		applicationContext = new AnnotationConfigApplicationContext(persoonConfig.class);
        
		System.out.println("Spring context initialized.");

		System.out.println(persoon1.getNaam());
		System.out.println(persoon2.getNaam());
		System.out.println("persoon1='" + persoon1.getNaam());
		System.out.println("persoon2='" + persoon2.getNaam());

	}

}
