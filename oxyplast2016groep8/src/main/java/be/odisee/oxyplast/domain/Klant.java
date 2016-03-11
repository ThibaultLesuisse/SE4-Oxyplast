package be.odisee.oxyplast.domain;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:35:14
 */

import org.springframework.stereotype.Component;

@Component("persoon1")
public class Klant implements IPersoon{

	private String Achternaam;
	private String BedrijfNaam;
	private String Email;
	private int ID;
	private String Voornaam;
	private String Naam;
	//public Feedback m_Feedback;

	public Klant(String achternaam, String bedrijfsnaam, String email2, String voornaam){
			this.Achternaam = achternaam;
			this.BedrijfNaam = bedrijfsnaam;
			this.Email = email2;
			this.Voornaam = voornaam;
			this.ID = 1;
			
	}



	/**
	 * 
	 * @param Naam
	 */
	public Klant(String Naam){
		Achternaam = Naam;
	}
	public Klant(){
		
	}
	/**
	 * 
	 * @param Naam
	 * @param ID
	 * @return 
	 */
	public void KlantVerwijderen(String Naam, int ID){

	}
	public String getKlantNaam(){
		
		return Achternaam;
	}
	public int getKlantID(){
		return ID;
	}



	public int getID(String naam) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Autowired
	public void setNaam(String naam) {
		this.Naam = naam;
	}



	public String getNaam() {
		return this.Naam;
	}

}