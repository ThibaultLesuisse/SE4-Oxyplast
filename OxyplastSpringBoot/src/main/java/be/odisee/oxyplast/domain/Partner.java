package be.odisee.oxyplast.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="partners")
@DiscriminatorValue(value = "Partner")
public class Partner extends Rol{
	

	@Column(name="partnerid")
	private int partnerid;
	
	@Column(name="partnernaam")
	private String naam;
	
	@Column(name="partnervoornaam")
	private String voornaam;
	
	public Partner() {
		
	}
	
	public Partner(int id, String naam, String voornaam) {
		this.partnerid = id;
		this.naam = naam;
		this.voornaam = voornaam;
	}

	public Partner(String status, String usernaam, Sessie sessie, Persoon persoon) {
		 super(status,usernaam,sessie,persoon);
	}



	public int getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(int partnerid) {
		this.partnerid = partnerid;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	@Override
	public String getType() {
		return "Partner";
	}
}
