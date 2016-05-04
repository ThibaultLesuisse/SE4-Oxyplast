package be.odisee.oxyplast.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.odisee.oxyplast.domain.Persoon;
import be.odisee.oxyplast.domain.Sessie;
import be.odisee.oxyplast.domain.Rol;;


/**
 * @author Lesuisse
 * @version 1.0
 * @created 24-Feb-2016 13:44:21
 */
@Entity

@Table(name="onderzoeker")
@DiscriminatorValue("Onderzoeker")
public class Onderzoeker extends Rol {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column
	private String naam;
	
	@Column
	private String voornaam;
	
	@Column
	private int teamid;

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
	    
	    //tabel? team?
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


		public int getTeamid() {
			return teamid;
		}


		public void setTeamid(int teamid) {
			this.teamid = teamid;
		}


		public Onderzoeker(int id, String naam, String voornaam, int teamid){
			this.id = id;
			this.naam = naam;
			this.voornaam = voornaam;
			this.teamid = teamid;
		}

}
