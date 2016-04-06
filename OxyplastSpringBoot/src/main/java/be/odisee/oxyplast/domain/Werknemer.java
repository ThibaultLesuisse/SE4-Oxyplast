package be.odisee.oxyplast.domain;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 24-Feb-2016 13:44:14
 */
public class Werknemer implements IPersoon{

	private int BadgeNummer;
	private int WerknemerID;
	protected String Naam;

	public Werknemer(){

	}

	public void finalize() throws Throwable {

	}

	public void Degradeer(){

	}

	public void Ontsla(){

	}

	public void Promoveer(){

	}

	public void Schors(){

	}

	public void VerwijderVangeschorst(){

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