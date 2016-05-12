package be.odisee.oxyplast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="partners")
public class Partner extends Rol{
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="partnerid")
	private int id;
	
	@Column
	private String naam;
	
	@Column
	private String voornaam;
	
	public Partner() {
		
	}
	
	public Partner(int id, String naam, String voornaam) {
		this.id = id;
		this.naam = naam;
		this.voornaam = voornaam;
	}

	public Partner(String status, String usernaam, Sessie sessie, Persoon persoon) {
		 super(status,usernaam,sessie,persoon);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
