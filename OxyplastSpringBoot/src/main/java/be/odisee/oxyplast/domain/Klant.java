package be.odisee.oxyplast.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="klantid")
	private int klantId;
	
	@Column(name="klantvoornaam")
	private String voornaam;
	
	@Column(name="klantnaam")
	private String naam;
	
	@OneToOne(mappedBy="klant")
	private Aanvraag aanvraag;
	
	
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
		public int getKlantId() {
			return klantId;
		}

		public void setKlantId(int klantId) {
			this.klantId = klantId;
		}

		public String getVoornaam() {
			return voornaam;
		}

		public void setVoornaam(String voornaam) {
			this.voornaam = voornaam;
		}

		public String getNaam() {
			return naam;
		}

		public void setNaam(String naam) {
			this.naam = naam;
		}

		public Aanvraag getAanvraag() {
			return aanvraag;
		}

		public void setAanvraag(Aanvraag aanvraag) {
			this.aanvraag = aanvraag;
		}
}