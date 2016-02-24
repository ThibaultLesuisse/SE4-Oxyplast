package BE.Odisee.Oxyplast.Domain;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:35:14
 */
public class Klant {

	private String Achternaam;
	private String BedrijfNaam;
	private String Email;
	private int ID;
	private String Voornaam;
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

}