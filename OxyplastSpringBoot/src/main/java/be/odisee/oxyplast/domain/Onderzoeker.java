package be.odisee.oxyplast.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import be.odisee.oxyplast.domain.Persoon;
import be.odisee.oxyplast.domain.Sessie;
import be.odisee.oxyplast.domain.Rol;;


/**
 * @author Lesuisse
 * @version 1.0
 * @created 24-Feb-2016 13:44:21
 */
@Entity
@DiscriminatorValue("Onderzoeker")
public class Onderzoeker extends Rol {

	 public Onderzoeker(){}

	    public Onderzoeker(String status, String usernaam, Sessie sessie, Persoon persoon){
	        super(status,usernaam,sessie,persoon);
	    }

	    public Onderzoeker(int id, String status, String usernaam, Sessie sessie, Persoon persoon){
	        super(id,status,usernaam,sessie,persoon);
	    }

	    @Override
	    public String getType() {
	        return "Onderzoeker";
	    }

}