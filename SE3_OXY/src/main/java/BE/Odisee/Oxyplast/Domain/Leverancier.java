package BE.Odisee.Oxyplast.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 24-Feb-2016 13:44:06
 */

@Component("persoon2")
public class Leverancier implements IPersoon{

	private int LeverancierID;
	private String Naam;

	public Leverancier(){
		
	}
	
	@Autowired
	public Leverancier(String setNieuweLeverancierNaam){
		this.Naam = setNieuweLeverancierNaam;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param Naam
	 */
	public int LeverancierID(String Naam){
		return 0;
	}

	public int getID(String naam) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setNaam(String naam) {
		this.Naam = naam;		
	}

	public String getNaam() {
		return this.Naam;
	}

}