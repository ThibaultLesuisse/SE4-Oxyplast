package BE.Odisee.Oxyplast.Domain;

/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:35:30
 */
public class Project {

	private int ProjectID;
	private int ProjectTeamID;
	private String Rentabiliteit;
	private String Status;
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