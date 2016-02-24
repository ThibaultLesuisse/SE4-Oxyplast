package BE.Odisee.Oxyplast.Domain;

import java.awt.List;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 24-Feb-2016 13:42:44
 */
public class Prototype {

	private String Formule;
	private int OnderzoekerID;
	private int PrototypeID;
	public Feedback m_Feedback;
	public Grondstof m_Grondstof;

	public Prototype(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param Formule
	 */
	public int PrototypeID(String Formule){
		return 0;
	}

	public List GetGrondstoffen(){
		return null;
	}

	/**
	 * 
	 * @param Feedback
	 */
	public void SetFeedback(String Feedback){

	}

	/**
	 * 
	 * @param String
	 */
	public void SetFormule(int String){

	}

}