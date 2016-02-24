package BE.Odisee.Oxyplast.Domain;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 24-Feb-2016 13:43:59
 */
public class Grondstof {

	private int GrondstofID;
	private String Grondstofnaam;
	private double Hoeveelheid;
	private Leverancier m_Leverancier;

	public Grondstof(){

	}

	public void finalize() throws Throwable {

	}

	public int BerekenPrijs(){
		return 0;
	}

	/**
	 * 
	 * @param Naam
	 * @param Hoeveelheid
	 */
	public void grondstof(String Naam, int Hoeveelheid){
		
	}

}