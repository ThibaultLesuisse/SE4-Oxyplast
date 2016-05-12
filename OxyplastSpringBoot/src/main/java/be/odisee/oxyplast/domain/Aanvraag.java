package be.odisee.oxyplast.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.Index;
/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:35:23
 */
@Entity
@Table(name="aanvraag")
public class Aanvraag {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="klantid")
	private int klantid;
	
	@Column
	private String aanvraag;
	//public Prototype m_Prototype;
	//public Team m_Team;


	public Aanvraag(){

	}


	/**
	 * 
	 * @param Aanvraag
	 * @param AanvragerID
	 */
	public Aanvraag(int id, int klantid , String aanvraag){
		this.id = id;
		this.klantid = klantid;
		this.aanvraag = aanvraag;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getKlantid() {
		return klantid;
	}


	public void setKlantid(int klantid) {
		this.klantid = klantid;
	}


	public String getAanvraag() {
		return aanvraag;
	}


	public void setAanvraag(String aanvraag) {
		this.aanvraag = aanvraag;
	}

	/**
	 * 
	 * @param ID
	 * @return 
	 */

}