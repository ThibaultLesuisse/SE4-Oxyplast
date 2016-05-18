package be.odisee.oxyplast.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="leverancier")
public class Leverancier{

	@Id
	@Column
	private int id;
	
	@Column
	private String adres;
	
	@Column 
	private String email;
	
	@Column 
	private int telefoonnummer;
	
	 @OneToMany(fetch=FetchType.EAGER, mappedBy="leverancier")
	 private Set<Bestelling> m_Bestelling= new HashSet<Bestelling>();

	public Leverancier(){

	}
	public Leverancier(int id, String adres, String email, int telefoonnummer){
		this.id = id;
		this.adres = adres;
		this.email = email;
		this.telefoonnummer = telefoonnummer;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(int telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	

	/**
	 * 
	 * @param Naam
	 */


}