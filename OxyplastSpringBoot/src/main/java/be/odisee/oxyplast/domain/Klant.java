package be.odisee.oxyplast.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:35:14
 */

import be.odisee.oxyplast.domain.Persoon;
import be.odisee.oxyplast.domain.Sessie;
import be.odisee.oxyplast.domain.Rol;

@SuppressWarnings("serial")
@Entity
@Table(name="klanten")
@DiscriminatorValue("Klant")
public class Klant {

	
	@Id
	@Column(name="klantid")
	public int klantid;
	
	@Column(name="klantvoornaam")
	public String voornaam;
	
	@Column(name="klantnaam")
	public String naam;
	
	@OneToOne(mappedBy="klant")
	public Aanvraag aanvraag;
	
	
	 public Klant(){}

	    public Klant(String status, String usernaam, Sessie sessie, Persoon persoon){
	      
	    }

	    public Klant(int id, String status, String usernaam, Sessie sessie, Persoon persoon){
	    
	    }

	    
		public int getKlantId() {
			return klantid;
		}

		public void setKlantId(int klantId) {
			this.klantid = klantId;
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