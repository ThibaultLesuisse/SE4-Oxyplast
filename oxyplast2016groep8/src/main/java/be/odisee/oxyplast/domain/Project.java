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
	private int ProjectID;
	
	@Column(name="TeamId")
	private int ProjectTeamID;
	
	//private String Rentabiliteit;
	
	@Column
	@Index(name="IProject_status",columnNames="Status")
	private String Status;
	
	@Column(name="Naam")
	@Index(name="IProject_naam",columnNames="Naam")
	private String ProjectNaam;
	//public Prototype m_Prototype;
	//public Team m_Team;

	public Project(){

	}




	/**
	 * 
	 * @param TeamID
	 * @param Status
	 */
	public Project(int TeamID, String Status, String naam){
		this.ProjectTeamID = TeamID;
		this.Status = Status;
		this.ProjectNaam = naam;
	}
	public String getProjectNaam(){
		return this.ProjectNaam;
	}
	public String getProjectStatus(){
		return this.Status;
	}
	public int getProjectTeamId(){
		return this.ProjectTeamID;
	}
	public int getProjectId(){
		return this.ProjectID;
	}




	public int getProjectID() {
		return ProjectID;
	}




	public void setProjectID(int projectID) {
		ProjectID = projectID;
	}




	public int getProjectTeamID() {
		return ProjectTeamID;
	}




	public void setProjectTeamID(int projectTeamID) {
		ProjectTeamID = projectTeamID;
	}


	public String getStatus() {
		return Status;
	}




	public void setStatus(String status) {
		Status = status;
	}




	public void setProjectNaam(String projectNaam) {
		ProjectNaam = projectNaam;
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