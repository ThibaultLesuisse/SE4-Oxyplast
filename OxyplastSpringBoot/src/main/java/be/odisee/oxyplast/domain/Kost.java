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

	public double getKosthoeveelheid() {
		return Kosthoeveelheid;
	}

	public void setKosthoeveelheid(double kosthoeveelheid) {
		Kosthoeveelheid = kosthoeveelheid;
	}

	public Project getM_Project() {
		return m_Project;
	}

	public void setM_Project(Project m_Project) {
		this.m_Project = m_Project;
	}

	public Accountverantwoordelijke getM_Accountverantwoordelijke() {
		return m_Accountverantwoordelijke;
	}

	public void setM_Accountverantwoordelijke(Accountverantwoordelijke m_Accountverantwoordelijke) {
		this.m_Accountverantwoordelijke = m_Accountverantwoordelijke;
	}

}