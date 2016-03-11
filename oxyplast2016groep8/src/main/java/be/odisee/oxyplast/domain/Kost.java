package be.odisee.oxyplast.domain;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 24-Feb-2016 13:43:39
 */
public class Kost {

	private double Kosthoeveelheid;
	public Project m_Project;
	public Accountverantwoordelijke m_Accountverantwoordelijke;

	public Kost(){

	}

	public void finalize() throws Throwable {

	}

	public double BerekenKosten(){
		return 0;
	}

}