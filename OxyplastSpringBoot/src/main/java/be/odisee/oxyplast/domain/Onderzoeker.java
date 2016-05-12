package be.odisee.oxyplast.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import be.odisee.oxyplast.domain.Persoon;
import be.odisee.oxyplast.domain.Sessie;
import be.odisee.oxyplast.domain.Rol;;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 24-Feb-2016 13:44:21
 */

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("Onderzoeker")
public class Onderzoeker extends Rol {
	
	@Column(name="onderzoekerid")
	protected int onderzoekerid;
	
	@Column(name="onderzoekernaam")
	protected String onderzoekernaam;
	
	@Column(name="onderzoekervoornaam")
	protected String onderzoekervoornaam;
	
	@ManyToOne
	@JoinColumn(name="teamid")
	protected Team team;

	   
		public int getOnderzoekerid() {
		return onderzoekerid;
	}
		public void setOnderzoekerid(int onderzoekerid) {
			this.onderzoekerid = onderzoekerid;
		}
			
		public String getOnderzoekernaam() {
			return onderzoekernaam;
		}
		public void setOnderzoekernaam(String onderzoekernaam) {
			this.onderzoekernaam = onderzoekernaam;
		}
		public String getOnderzoekervoornaam() {
			return onderzoekervoornaam;
		}
		public void setOnderzoekervoornaam(String onderzoekervoornaam) {
			this.onderzoekervoornaam = onderzoekervoornaam;
		}
		public Team getTeamid() {
			return team;
		}


		public void setTeamid(Team team) {
			this.team = team;
		}


		public Onderzoeker(int id, String naam, String voornaam, Team team){
			this.onderzoekerid = id;
			this.onderzoekernaam = naam;
			this.onderzoekervoornaam = voornaam;
			this.team = team;
		}
		 public Onderzoeker(String status, String usernaam, Sessie sessie, Persoon persoon){
		        super(status,usernaam,sessie,persoon);
		   
		    
		    }


		@Override
		public String getType() {
			return "Onderzoeker";
		}

}
