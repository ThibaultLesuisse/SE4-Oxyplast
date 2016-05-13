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
@Table(name="bestelling")
public class Bestelling {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bestellingid")
	private int id;
	
	@Column
	private int aantal;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="leverancierid")
	private Leverancier leverancier;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="projectid")
	protected Project project;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="prototypeid")
	protected Prototype prototype;
   
	  
	//@ManyToOne
	//private Project project;
	public Bestelling(){

	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public Leverancier getLeverancier() {
		return leverancier;
	}

	public void setLeverancier(Leverancier leverancier) {
		this.leverancier = leverancier;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Prototype getPrototype() {
		return prototype;
	}

	public void setPrototype(Prototype prototype) {
		this.prototype = prototype;
	}

	public Bestelling(int id, int aantal, Leverancier l, Project p, Prototype pr) {
	this.id = id;
	this.aantal = aantal;
	this.leverancier = l;
	this.project = p;
	this.prototype = pr;
	
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}






}