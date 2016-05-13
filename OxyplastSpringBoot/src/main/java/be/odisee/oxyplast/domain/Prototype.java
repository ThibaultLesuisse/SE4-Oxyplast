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
@Inheritance(strategy=InheritanceType.JOINED)
public class Prototype {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Bestelling getBestelling() {
		return bestelling;
	}

	public void setBestelling(Bestelling bestelling) {
		this.bestelling = bestelling;
	}





	@Column
	private String formule;
	
   @ManyToOne
   @JoinColumn(name="projectid")
   protected Project project;

   
   @OneToOne(mappedBy="prototype")
   private Bestelling bestelling;
	//@ManyToOne
	//private Project project;
	public Prototype(){

	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public String getFormule() {
		return formule;
	}


	public void setFormule(String formule) {
		this.formule = formule;
	}

	public Prototype(int id, Project project , String formule){
		this.id = id;
		this.project = project;
		this.formule = formule;
	}


	

	/**
	 * 
	 * @param ID
	 * @return 
	 */

}