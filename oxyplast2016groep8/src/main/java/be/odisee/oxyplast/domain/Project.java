package be.odisee.oxyplast.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.Index;


/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:35:30
 */

@Entity
@Table(name="project")
public class Project implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="TeamId")
	private int teamId;
	
	//private String Rentabiliteit;
	
	@Column(name="Status")
	@Index(name="IProject_status",columnNames="Status")
	private String status;
	
	@Column(name="Naam")
	@Index(name="IProject_naam",columnNames="Naam")
	private String naam;
	//public Prototype m_Prototype;
	//public Team m_Team;

	public Project(){

	}




	/**
	 * 
	 * @param TeamID
	 * @param Status
	 */
	public Project(int id, int teamId, String status, String naam){
		this.teamId = teamId;
		this.status = status;
		this.naam = naam;
		this.id = id;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getTeamId() {
		return teamId;
	}




	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getNaam() {
		return naam;
	}




	public void setNaam(String naam) {
		this.naam = naam;
	}
	




	

	/**
	 * 
	 * @param Prototype
	 * @return 
	 */
	/*public void PrototypeToevoegen(Prototype Prototype){

	}
*/
	/**
	 * 
	 * @param Kost
	 * @param Opbrengst
	 */
	/*public int RendementBerekenen(Kost Kost, Opbrengst Opbrengst){
		
		
		return 0;
	}
	*/

	/**
	 * 
	 * @param TeamID
	 * @return 
	 */
	/*public void TeamToevoegen(int TeamID){

	}
	*/
	

	/**
	 * 
	 * @param TeamID
	 */
	/*public TeamVerwijderen(int TeamID){

	}
	*/

}