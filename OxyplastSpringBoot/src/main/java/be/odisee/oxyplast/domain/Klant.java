package be.odisee.oxyplast.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:35:14
 */

import org.springframework.stereotype.Component;
import be.odisee.oxyplast.domain.Persoon;
import be.odisee.oxyplast.domain.Sessie;
import be.odisee.oxyplast.domain.Rol;

@Entity
@DiscriminatorValue("Klant")
public class Klant extends Rol {

	 public Klant(){}

	    public Klant(String status, String usernaam, Sessie sessie, Persoon persoon){
	        super(status,usernaam,sessie,persoon);
	    }

	    public Klant(int id, String status, String usernaam, Sessie sessie, Persoon persoon){
	        super(id,status,usernaam,sessie,persoon);
	    }

	    @Override
	    public String getType() {
	        return "Klant";
	    }

}