package be.odisee.oxyplast.domain;

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

	public int getGrondstofID() {
		return GrondstofID;
	}

	public void setGrondstofID(int grondstofID) {
		GrondstofID = grondstofID;
	}

	public String getGrondstofnaam() {
		return Grondstofnaam;
	}

	public void setGrondstofnaam(String grondstofnaam) {
		Grondstofnaam = grondstofnaam;
	}

	public double getHoeveelheid() {
		return Hoeveelheid;
	}

	public void setHoeveelheid(double hoeveelheid) {
		Hoeveelheid = hoeveelheid;
	}

	public Leverancier getM_Leverancier() {
		return m_Leverancier;
	}

	public void setM_Leverancier(Leverancier m_Leverancier) {
		this.m_Leverancier = m_Leverancier;
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