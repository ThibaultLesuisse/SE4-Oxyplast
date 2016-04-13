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
@Table(name="prototype")
public class Prototype {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="projectid")
	private int projectid;
	
	@Column
	private String formule;



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getProjectid() {
		return projectid;
	}


	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}


	public String getFormule() {
		return formule;
	}


	public void setFormule(String formule) {
		this.formule = formule;
	}


	public Prototype(){

	}


	/**
	 * 
	 * @param Aanvraag
	 * @param AanvragerID
	 */
	public Prototype(int id, int projectid , String formule){
		this.id = id;
		this.projectid = projectid;
		this.formule = formule;
	}


	

	/**
	 * 
	 * @param ID
	 * @return 
	 */

}