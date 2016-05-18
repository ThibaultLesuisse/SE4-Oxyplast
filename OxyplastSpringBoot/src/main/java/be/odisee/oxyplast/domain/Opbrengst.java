package be.odisee.oxyplast.domain;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 24-Feb-2016 13:42:14
 */
public class Opbrengst {

	private double OpbrengenstenHoeveelheid;
	public Project m_Project;

	public Opbrengst(){

	}

	public double getOpbrengenstenHoeveelheid() {
		return OpbrengenstenHoeveelheid;
	}

	public void setOpbrengenstenHoeveelheid(double opbrengenstenHoeveelheid) {
		OpbrengenstenHoeveelheid = opbrengenstenHoeveelheid;
	}

	public Project getM_Project() {
		return m_Project;
	}

	public void setM_Project(Project m_Project) {
		this.m_Project = m_Project;
	}

	public void finalize() throws Throwable {

	}

	public double BerekenOpbrengst(){
		return 0;
	}

}