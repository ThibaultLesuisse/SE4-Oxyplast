package BE.Odisee.Oxyplast.Domain;


/**
 * @author Lesuisse
 * @version 1.0
 * @created 31-Dec-2015 11:35:23
 */
public class Aanvraag {

	private String Aanvraag;
	private int AanvraagID;
	private int AanvragerID;
	private String Status;
	private Boolean aanvaard = false;
	public Klant m_Klant;
	public Project m_Project;

	public Aanvraag(){

	}


	/**
	 * 
	 * @param Aanvraag
	 * @param AanvragerID
	 */
	public Aanvraag(String Aanvraag, int AanvragerID){
		this.Aanvraag = Aanvraag;
		this.AanvragerID = AanvragerID;
	}

	/**
	 * 
	 * @param ID
	 * @return 
	 */
	public void AanvraagAanvaarden(int ID){

	}

	public void annuleer(){

	}
	public void setAanvaard(){
		aanvaard = true;
	}
	public Boolean getAanvaard(){
		return aanvaard;
	}

	public void setGegegvens(){

	}

	public void VerwijderVanGeweigerd(){

	}

	public void Weiger(){

	}

	/**
	 * 
	 * @param ID
	 * @return 
	 */
	public void Weigeren(int ID){

	}

	public void ZetInWacht(){

	}

	public void ZetUitWachtrij(){

	}

}